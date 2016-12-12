#!/bin/bash
brew install node
brew update
brew install yarn
cd UI
yarn install
killall node
#killall screen
# lsof -i :3001 | grep LISTEN | awk {'print $2'}|xargs kill -9
# PORT=3001  nohup yarn start &
yarn run build