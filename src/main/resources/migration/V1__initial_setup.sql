CREATE TABLE notes (
  id                        SERIAL PRIMARY KEY,
  content                   character varying(100),
  timestamp                 timestamp,
  longest_palindrome_size   BIGINT
);

INSERT INTO notes
(content, timestamp, longest_palindrome_size) VALUES
('abrakadabra', '2018-10-09 00:12:12+0100', 3);
