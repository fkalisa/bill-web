package com.jb.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ConfigurationPropertiesScan("com.jb.bill.web")
public class BillWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillWebApplication.class, args);
	}

}
