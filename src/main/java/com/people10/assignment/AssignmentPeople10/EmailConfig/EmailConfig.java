package com.people10.assignment.AssignmentPeople10.EmailConfig;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Bean
	public JavaMailSender javaSendMail() {

		JavaMailSenderImpl javaImp = new JavaMailSenderImpl();
		javaImp.setUsername("mutturajdeval92@gmail.com");
		javaImp.setPassword("mutta14344");
		javaImp.setHost("smtp.gmail.com");
		javaImp.setPort(587);

		Properties props = javaImp.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return javaImp;

	}

}
