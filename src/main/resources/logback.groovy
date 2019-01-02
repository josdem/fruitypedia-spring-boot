logger("com.jos.dem", INFO)
appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%level %logger - %msg%n"
  }
}
root(ERROR, ["STDOUT"])
