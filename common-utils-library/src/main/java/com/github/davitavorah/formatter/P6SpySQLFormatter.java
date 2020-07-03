package com.github.davitavorah.formatter;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P6SpySQLFormatter implements MessageFormattingStrategy {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy HH:mm");

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return String.format("%s| %s", LocalDateTime.from(Instant.ofEpochMilli(Long.parseLong(now))).format(dateFormatter), sql);
    }
}
