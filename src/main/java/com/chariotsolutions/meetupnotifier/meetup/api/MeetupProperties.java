package com.chariotsolutions.meetupnotifier.meetup.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.annotation.PostConstruct;

@Component
public class MeetupProperties {

  private static final Logger logger = LoggerFactory.getLogger(MeetupProperties.class);

  public static String[] meetupGroups;
  public static String meetupApiKey;

  @PostConstruct
  public void loadMeetupProps() {
    Properties properties = new Properties();
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try (InputStream resourceStream = loader.getResourceAsStream("meetupGroups.properties")) {
      properties.load(resourceStream);
    } catch (IOException e) {
      logger.error("Failed to read meetup configuration file", e);
    }

    meetupGroups = properties.getProperty("meetup.groups").split(",");
    meetupApiKey = properties.getProperty("meetup.key");
    logger.debug("Meetups and API key loaded from file");
  }
}
