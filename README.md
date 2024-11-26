# Cron Expression Parser (Java)

## Overview
This Java application parses a standard cron expression and shows the exact times at which it will run.

---

## Requirements

- Java 21
- Maven (for building and testing)

## Build
mvn clean install

## Run
java -cp target/cron-parser-java-1.0-SNAPSHOT.jar com.parser.CronParser "*/15 0 1,15 * 1-5 /usr/bin/find"

## Input
*/15 0 1,15 * 1-5 /usr/bin/find

## Output
minute        0 15 30 45
hour          0
day of month  1
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find

