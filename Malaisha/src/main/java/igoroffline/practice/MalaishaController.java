package igoroffline.practice;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/m")
public class MalaishaController {

    private static final Logger log = LoggerFactory.getLogger(MalaishaController.class);

    @PostConstruct
    public void init() {
        log.info("MalaishaController INIT");
    }

    @Get("/hello")
    public AgeRecord hello() {
        return new AgeRecord(99);
    }
}