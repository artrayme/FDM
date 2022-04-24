#!/bin/bash
gradle bootJar
for f in build/libs/*jar; do
  cp "$f" /docker/application.jar
  break
done
