package com.CS5500.springbootinfrastructure;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Segment;
import com.CS5500.springbootinfrastructure.repos.DateLogRepository;
import com.CS5500.springbootinfrastructure.repos.SegmentRepository;
import net.minidev.json.JSONArray;
import org.apache.tomcat.jni.File;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
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

			// String exampleRequest = FileUtils.readFileToString(new File("exampleJsonRequest.json"), StandardCharsets.UTF_8);

			/*JsonParser parser = new JSONParser();
			try {
				Object allData = parser.parse(new FileReader("/storyline.json"));
				JSONObject jsonObject = (JSONObject)obj;
				String name = (String)jsonObject.get("Name");
				String course = (String)jsonObject.get("Course");
				JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
				System.out.println("Name: " + name);
				System.out.println("Course: " + course);
				System.out.println("Subjects:");
				Iterator iterator = subjects.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}


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
			log.info("");*/
		};
	}
}
