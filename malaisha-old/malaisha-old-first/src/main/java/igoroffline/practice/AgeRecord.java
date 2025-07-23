package igoroffline.practice;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AgeRecord(int value) {}