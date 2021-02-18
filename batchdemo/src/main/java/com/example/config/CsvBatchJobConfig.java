package com.example.config;


import com.example.pojo.User;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class CsvBatchJobConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    DataSource dataSource;

    @Bean
    @StepScope
    FlatFileItemReader<User> itemReader() {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("data.csv"));
        reader.setLineMapper(new DefaultLineMapper<User>() {{
                setLineTokenizer(new DelimitedLineTokenizer() {{
                        setNames("id", "name", "address", "gender");
                        setDelimiter("\t");
                    }});
                setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{ 
                    setTargetType(User .class);
                }});
        }});
    return reader;
}
/*@Bean
    JdbcBatchItemWriter jdbcBatchItemWriter(){
    JdbcBatchItemWriter<Object> writer = new JdbcBatchItemWriter<>();
    writer.setDataSource(dataSource);
    writer.setSql();
}*/
}