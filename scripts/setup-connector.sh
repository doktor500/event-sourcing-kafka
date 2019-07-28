#!/bin/bash

KAFKA_CONNECT_URL="http://localhost:8083/connectors"

curl -X POST -H "Content-Type: application/json" -d @connectors/source-config.json $KAFKA_CONNECT_URL