package com.chariotsolutions.meetupnotifier;


import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.meetup.api.GoogleConverter;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQueryExecutor;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import javax.sql.DataSource;

@Component
@EnableScheduling
public class MeetupNotifierImpl {

  @Autowired
  DataSource ds;

  private String[] groups;

  public void queryAndNotify() throws IOException {
    for (String meetupGroupName : groups) {
      JdbcTemplate template = new JdbcTemplate(ds);
      String metupInCalendarQuery = "SELECT * from calendar_event where meetupID=?";

      List<Result> results = new MeetupQueryExecutor()
          .executeQuery(new MeetupQuery(meetupGroupName)).getResults();

      for (Result result : results) {
        Event gev = new GoogleConverter().convertTo(result);
        List<CalendarEvent> tab = template.query(metupInCalendarQuery, eventMapper, result.getId());

        if (tab.size() == 0) {
          Event insertedEvent = App.cal.events().insert("primary", gev).execute();
          template.update("INSERT INTO calendar_event VALUES (?, ?)",
              insertedEvent.getId(), result.getId());
        } else {
          App.cal.events().update("primary", tab.get(0).getGoogleId(), gev).execute();
        }
      }
    }
  }

  RowMapper<CalendarEvent> eventMapper = (resultSet, ii) -> new CalendarEvent(
      resultSet.getString("googleID"),
      resultSet.getString("meetupID"));

  @Value("${meetup.groups}")
  public void setGroups(String[] groups) {
    this.groups = groups;
  }
}
