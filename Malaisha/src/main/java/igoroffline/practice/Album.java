package igoroffline.practice;

import java.time.LocalDateTime;

public record Album(Integer id, String name, LocalDateTime ctime, LocalDateTime mtime) {
}
