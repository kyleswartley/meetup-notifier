package com.chariotsolutions.meetupnotifier;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AppBeanImpl {

  private static final Logger logger = LoggerFactory.getLogger(AppBeanImpl.class);

  @Scheduled(fixedRate = 60000L)
  public void run() {
    logger.warn("Log entry!");
  }
}
