package com.electronica.formula_1.data.circuit;

import com.electronica.formula_1.model.Circuit;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CircuitJobCompletionNotificationListener implements JobExecutionListener {
    private static final Logger logger = Logger.getLogger(CircuitJobCompletionNotificationListener.class.getName());

    private final JdbcTemplate jdbcTemplate;

    public CircuitJobCompletionNotificationListener(JdbcTemplate jdbcTemplate, JdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("!!!Job completed! Time to verify the results");

            jdbcTemplate
                    .query("SELECT circuitRef , name, url FROM circuits", new DataClassRowMapper<>(Circuit.class))
                    .forEach(circuit -> logger.info("Found <{{}}> in the database."));
        }
    }
}
