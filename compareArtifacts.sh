#!/bin/sh
MAVEN=target/cartshop-1.0-SNAPSHOT.war
GRADLE=build/libs/cartshop-1.0-SNAPSHOT.jar

ls -l --block-size=M $MAVEN  | awk '{print $9, $5}'
ls -l --block-size=M $GRADLE  | awk '{print $9, $5}'