package igoroffline.practice;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.time.LocalDateTime;

@Controller("/api")
public class Renata {

    @Get("/album")
    public HttpResponse<Album> getOneAlbum() {
        final var now = LocalDateTime.now();
        return HttpResponse.ok(new Album(77, "SeventySeven", now, now));
    }
}
