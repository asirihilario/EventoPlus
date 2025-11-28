package com.jemrcode.util;

@FunctionalInterface
public interface LineParser<T> {
    T parse(String line);
}