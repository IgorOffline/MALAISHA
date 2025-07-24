package igoroffline.practice;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/v")
public class Kontrola {

    private final Logger log = LoggerFactory.getLogger(Kontrola.class);

    private final Jdbi jdbi;

    public Kontrola(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    @Get("/h")
    public String getHello() {
        final var one = jdbi.withHandle(handle -> handle.createQuery("SELECT 1").mapTo(Integer.class).one());
        log.info("one= {}", one);

        final var name = jdbi.withHandle(handle -> handle.createQuery("SELECT name FROM album").mapTo(String.class).one());
        log.info("name= {}", name);

        final var albums = jdbi
                .withHandle(handle -> handle.createQuery("SELECT a.id_album AS id, a.name, a.ctime, a.mtime FROM album a")
                        .registerRowMapper(Album.class, (rs, ctx) ->
                                new Album(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime(), rs.getTimestamp(4).toLocalDateTime()))
                        .mapTo(Album.class).list());
        log.info("albums= {}", albums);

        return "hello!";
    }
}
