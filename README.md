### Useful commands

```
docker exec -ti $(docker ps --filter "ancestor=event-sourcing-kafka-poc_postgresql" --format="{{.ID}}") bash
su - postgres
psql
\c eventsdb
select * from events;
```
