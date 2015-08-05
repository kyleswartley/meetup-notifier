CREATE TABLE id_table(
  googleId VARCHAR(1024) NOT NULL, -- 1024 is the maximum length of a Google calendar event ID
  meetupId VARCHAR(1024) NOT NULL,
  UNIQUE (googleId, meetupId)
);