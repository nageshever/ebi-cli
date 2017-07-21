package uk.ac.ebi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbiCliApplication {
	final static Logger log = LoggerFactory.getLogger(EbiCliApplication.class);
	@Value("${accession.numbers}")
	String accessionNumbers;
	
	public static void main(String[] args) {
		SpringApplication.run(EbiCliApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		
		return args -> {
			Main main = new Main();
			log.info(main.returnOrderedAccessionNumbers(accessionNumbers));
		};
	}
}
