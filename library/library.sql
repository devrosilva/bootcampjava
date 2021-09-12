CREATE TABLE authors (
	id integer PRIMARY KEY,
	name varchar,
	birthdate date,
	email varchar,
	resume varchar
);

CREATE SEQUENCE authors_sequence owned by authors.id;

ALTER TABLE authors ALTER COLUMN id SET DEFAULT nextval('authors_sequence');