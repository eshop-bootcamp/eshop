#!/bin/bash
lsof -t -i :8443 | xargs kill -9