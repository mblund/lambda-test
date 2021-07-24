#!/bin/sh
# Compiles to Java classes, builds a jar, and then compiles to a native Linux executable 

set -e

mkdir -p dist

docker build --network host -f linuxtest.dockerfile -t linuxtest .
docker run -v "$(pwd -P)":/tmp/src linuxtest
