#!/bin/bash
docker build --no-cache -f build-fdm.Dockerfile -t artrayme/fdm-build .
docker run -v $(pwd)/docker:/docker -t artrayme/fdm-build -it
cd docker
docker-compose build --no-cache fdm
docker-compose up
