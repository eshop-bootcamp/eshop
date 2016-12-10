#!/bin/bash
brew install node
brew update
brew install yarn
cd UI
yarn install
killall node
#killall screen
screen
PORT=3001 yarn start
screen -d