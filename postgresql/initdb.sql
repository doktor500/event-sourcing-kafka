CREATE TABLE EVENTS (
  id SERIAL PRIMARY KEY,
  task_id INTEGER NOT NULL,
  type VARCHAR(64) NOT NULL,
  payload JSONB NOT NULL,
  date_created TIMESTAMP NOT NULL
);

CREATE TABLE SUMMARY (
  task_id SERIAL PRIMARY KEY,
  payload JSONB NOT NULL
);

CREATE INDEX IDX_TASK_ID ON EVENTS (task_id);

INSERT INTO EVENTS (task_id, type, payload, date_created) VALUES(
  1,
  'task-received',
  '{"title": "Investigate how to build event sourcing with Kafka"}'::JSONB,
  '2019-01-01 00:00:00'
);

INSERT INTO EVENTS (task_id, type, payload, date_created) VALUES(
  1,
  'task-assigned',
  '{"name": "David Molinero"}'::JSONB,
  '2019-01-01 00:01:00'
);
