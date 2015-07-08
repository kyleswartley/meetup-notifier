package com.chariotsolutions.meetupnotifier.meetup.api;

import com.chariotsolutions.meetupnotifier.meetup.api.messages.Results;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class MeetupQuery {
  /**
   *
   * @return ResultsObject containing the results of the call.
   * @throws IOException In case of an error communicating with the API.
   */
  public static Results fetchMeetups() throws IOException {
    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpGet getRequest = new HttpGet("https://api.meetup.com/2/events?offset=0&format=json&limited_events=False&group_urlname=phillypug&text_format=plain&photo-host=public&page=20&fields=timezone&order=time&desc=false&status=upcoming&sig_id=188504148&sig=87e57bf49005cb980d48f87bd8c4bc53df8fa1f3");
    getRequest.addHeader("accept", "application/json");
    HttpResponse response = client.execute(getRequest);

    ObjectMapper mapper = new ObjectMapper();
    JsonFactory jsonFactory = new JsonFactory();
    JsonParser jsonParser = jsonFactory.createParser(response.getEntity().getContent());

    Results resultsObject = mapper.readValue(jsonParser, Results.class);

    String out = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultsObject);
    System.out.println(out);

    return resultsObject;
  }
}
