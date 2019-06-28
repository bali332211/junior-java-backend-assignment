DROP TABLE IF EXISTS notes;

CREATE TABLE notes (
  id                        SERIAL PRIMARY KEY,
  content                   character varying(100),
  timestamp                 timestamp,
  longest_palindrome_size   BIGINT
);
