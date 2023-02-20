package com.simpleAPI.codeTest;

import com.simpleAPI.codeTest.configuration.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class CodeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeTestApplication.class, args);
	}

}
