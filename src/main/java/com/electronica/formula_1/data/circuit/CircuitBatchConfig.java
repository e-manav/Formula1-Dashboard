package com.electronica.formula_1.data.circuit;

import com.electronica.formula_1.model.Circuit;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
public class CircuitBatchConfig {
    private final String[] FIELD_NAMES = new String[]{
            "circuitId", "circuitRef", "name", "location", "country", "lat", "lng", "alt", "url"
    };

    @Bean
    public FlatFileItemReader<CircuitInput> circuitInputFlatFileItemReader() {
        return new FlatFileItemReaderBuilder<CircuitInput>()
                .name("circuitItemReader")
                .resource(new ClassPathResource("csv/circuits.csv"))
                .delimited()
                .names(FIELD_NAMES)
                .targetType(CircuitInput.class)
                .build();
    }

    @Bean
    public CircuitItemProcessor circuitItemProcessor() {
        return new CircuitItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Circuit> circuitJdbcBatchItemWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Circuit>()
                .sql("INSERT INTO circuits (circuitId, circuitRef, name, location, country, lat, lng, alt, url) " +
                        "VALUES (:circuitId, :circuitRef, :name, :location,:country, :lat, :lng, :alt, :url)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

	@Bean
	public Job importUserJob(JobRepository jobRepository,Step step1, CircuitJobCompletionNotificationListener listener) {
		return new JobBuilder("importUserJob", jobRepository)
			.listener(listener)
			.start(step1)
			.build();
	}
    @Bean
    public Step step1(JobRepository jobRepository, DataSourceTransactionManager transactionManager,
                      FlatFileItemReader<CircuitInput> circuitInputFlatFileItemReader,
                      CircuitItemProcessor circuitItemProcessor, JdbcBatchItemWriter<Circuit> circuitJdbcBatchItemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<CircuitInput, Circuit> chunk(3, transactionManager)
                .reader(circuitInputFlatFileItemReader)
                .processor(circuitItemProcessor)
                .writer(circuitJdbcBatchItemWriter)
                .build();
    }
}
