#!/bin/sh

set -eu
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home/
java -cp target/classes/ com.iteratrlearning.blog_examples.java9_cf.PriceCatalogueExample