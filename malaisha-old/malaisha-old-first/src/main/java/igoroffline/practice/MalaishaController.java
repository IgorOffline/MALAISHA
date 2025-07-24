package igoroffline.practice;

import igoroffline.practice.generated.public_.tables.Album;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.views.View;
import jakarta.annotation.PostConstruct;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/m")
public class MalaishaController {

    private static final Logger log = LoggerFactory.getLogger(MalaishaController.class);

    private final MalaishaGenerator generator;
    private final DSLContext dslContext;

    public MalaishaController(MalaishaGenerator generator, DSLContext dslContext) {
        this.generator = generator;
        this.dslContext = dslContext;
    }

    @PostConstruct
    public void init() {
        log.info("MalaishaController INIT");
    }

    @View("hello")
    @Get("/hello")
    public HttpResponse<AgeRecord> hello() {
        return HttpResponse.ok(new AgeRecord(99));
    }

    @View("generate")
    @Get("/generate")
    public HttpResponse<AgeRecord> generate() {
        generator.generate();
        return HttpResponse.ok(new AgeRecord(200));
    }

    @View("populate")
    @Get("/populate")
    public HttpResponse<AgeRecord> populate() {
        final var populateCount = dslContext.selectCount().from(Album.ALBUM).fetch().size();
        log.debug("populateCount= {}", populateCount);
        return HttpResponse.ok(new AgeRecord(300));
    }
}