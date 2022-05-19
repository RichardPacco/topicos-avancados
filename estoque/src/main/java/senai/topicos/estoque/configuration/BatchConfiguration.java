package senai.topicos.estoque.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import senai.topicos.estoque.batch.items.CompraProcessor;
import senai.topicos.estoque.batch.items.CompraReader;
import senai.topicos.estoque.batch.items.CompraWriter;
import senai.topicos.estoque.domain.entity.Compra;

@Configuration
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public CompraReader compraReader() {
        return new CompraReader();
    }

    @Bean
    public CompraProcessor compraProcessor() {
        return new CompraProcessor();
    }

    @Bean
    public CompraWriter compraWriter() {
        return new CompraWriter();
    }

    @Bean
    public Job processJob(CompraReader compraReader, CompraProcessor compraProcessor, CompraWriter compraWriter) {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .flow(orderStep1(compraReader, compraProcessor, compraWriter)).end().build();
    }

    @Bean
    public Step orderStep1(CompraReader compraReader, CompraProcessor compraProcessor, CompraWriter compraWriter) {
        return stepBuilderFactory.get("orderStep1").
                        <Compra, Compra>chunk(1)
                .reader(compraReader)
                .processor(compraProcessor)
                .writer(compraWriter)
                .build();
    }
}

