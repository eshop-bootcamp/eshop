#!/bin/bash
lsof -t -i :8443 | xargs kill -9
sleep 5
nohup ./gradlew bootrun &> core_bootrun-log.log &
