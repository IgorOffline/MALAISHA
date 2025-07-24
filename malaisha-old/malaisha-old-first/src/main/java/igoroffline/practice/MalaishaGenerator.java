package igoroffline.practice;

import jakarta.inject.Singleton;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Database;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class MalaishaGenerator {

    private final Logger log = LoggerFactory.getLogger(MalaishaGenerator.class);

    private final MalaishaDatasourceParams datasource;

    public MalaishaGenerator(MalaishaDatasourceParams datasource) {
        this.datasource = datasource;
    }

    public void generate() {
        final var configuration = new Configuration().withJdbc(
                        new Jdbc()
                                .withDriver("org.postgresql.Driver")
                                .withUrl(datasource.url())
                                .withUser(datasource.username())
                                .withPassword(datasource.password()))
                .withGenerator(
                        new Generator().withDatabase(
                                        new Database().withName("org.jooq.meta.postgres.PostgresDatabase"))
                                .withTarget(new Target()
                                        .withPackageName("igoroffline.practice.generated")
                                        .withDirectory("src/main/java")));

        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
