package com.CS5500.springbootinfrastructure;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Segment;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import com.CS5500.springbootinfrastructure.repos.SegmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class SpringBootInfrastructureApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootInfrastructureApplication.class);
	DateLogRepository dlRepo;
	SegmentRepository sgRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInfrastructureApplication.class, args);
	}


	@Bean
	public CommandLineRunner populateFromJSON() {
		return (args) -> {
			Segment seg = new Segment();
			sgRepo.save(seg);

			DateLog obj = new DateLog();
			obj.setDate(new Date(System.currentTimeMillis()));
			obj.timestampLastUpdate();
			obj.setSegment(seg);
			dlRepo.save(obj);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (DateLog dlog : dlRepo.findAll()) {
				log.info(dlog.getDate().toString());
			}
			log.info("");
		};
	}
}
