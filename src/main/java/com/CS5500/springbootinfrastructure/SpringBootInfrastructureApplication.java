package com.CS5500.springbootinfrastructure;

import com.CS5500.springbootinfrastructure.dao.DateLog;
import com.CS5500.springbootinfrastructure.dao.Segment;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.objectweb.asm.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootInfrastructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInfrastructureApplication.class, args);
	}



}
