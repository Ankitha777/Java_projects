Drop Table IF EXISTS Movie;
Drop Table IF EXISTS Rating;

CREATE table Movie(
MID integer primary key,
movieName VARCHAR2(255) NOT NULL
);

