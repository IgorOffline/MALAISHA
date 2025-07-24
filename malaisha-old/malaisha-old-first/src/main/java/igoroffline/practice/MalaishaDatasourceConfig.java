package igoroffline.practice;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

import javax.sql.DataSource;

@Factory
public class MalaishaDatasourceConfig {

    private final MalaishaDatasourceParams malaishaDatasourceParams;

    public MalaishaDatasourceConfig(MalaishaDatasourceParams malaishaDatasourceParams) {
        this.malaishaDatasourceParams = malaishaDatasourceParams;
    }

    @Bean
    @Singleton
    public DataSource dataSource() {
        final var hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMinimumIdle(1);
        hikariConfig.setConnectionTimeout(30000);
        hikariConfig.setIdleTimeout(30000);
        hikariConfig.setMaxLifetime(30000);
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setJdbcUrl(malaishaDatasourceParams.url());
        hikariConfig.setUsername(malaishaDatasourceParams.username());
        hikariConfig.setPassword(malaishaDatasourceParams.password());
        hikariConfig.setConnectionTestQuery("SELECT 1");

        return new HikariDataSource(hikariConfig);
    }
}
