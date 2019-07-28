### Event sourcing with kafka POC

This is a proof of concept on how to use postgres, kafka, kafka connect and kafka streams to generate a real time view that aggregates the events persisted in an event store.

#### Import events

    ./scripts/generate-events.sh
    
#### Setup source connector

    ./scripts/setup-connector.sh

#### Connect to Postgres Docker container and execute a query

```
docker exec -ti $(docker ps --filter "ancestor=event-sourcing-kafka-poc_postgresql" --format="{{.ID}}") bash
su - postgres
psql
\c eventsdb
select * from events;
```
