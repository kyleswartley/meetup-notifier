package com.chariotsolutions.meetupnotifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalendarEventDao {

  @Autowired
  private JdbcTemplate template;

  void insertEvent(String googleId, String meetupId) {
    template.update(
        "INSERT INTO calendar_event VALUES (?, ?)", googleId, meetupId);
  }

  List<CalendarEvent> findEventsByMeetupId(String meetupId) {
    return template.query(
        "SELECT * from calendar_event where meetupID=?", eventMapper, meetupId);
  }

  private RowMapper<CalendarEvent> eventMapper = (resultSet, ii) -> new CalendarEvent(
      resultSet.getString("googleID"),
      resultSet.getString("meetupID"));


}
