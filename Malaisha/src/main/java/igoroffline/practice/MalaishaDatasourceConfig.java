package igoroffline.practice;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;

import javax.sql.DataSource;

@Factory
public class MalaishaDatasourceConfig {

    private final MalaishaDatasourceParams malaishaDatasourceParams;

    public MalaishaDatasourceConfig(MalaishaDatasourceParams malaishaDatasourceParams) {
        this.malaishaDatasourceParams = malaishaDatasourceParams;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        final var hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setJdbcUrl(malaishaDatasourceParams.url());
        hikariConfig.setUsername(malaishaDatasourceParams.username());
        hikariConfig.setPassword(malaishaDatasourceParams.password());
        hikariConfig.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(hikariConfig);
    }
}
