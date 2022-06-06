package senai.topicos.estoque;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class EstoqueApplication {
//TODO subir aplicação para nuvem, heroku blablabal
    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }

}
