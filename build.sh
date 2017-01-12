#!/bin/sh

set -eu

export out=target/classes

rm -rf $out
mkdir -p $out
javac $(find src/main/java/ -name "*.java") -d $out

