package igoroffline.practice;

import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
public record Album(Integer id, String name, LocalDateTime ctime, LocalDateTime mtime) {
}
