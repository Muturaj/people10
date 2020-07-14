package com.people10.assignment.AssignmentPeople10.EmailConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImp {

	@Autowired
	private JavaMailSender emailSender;
	public void sendSimpleMessage(String to, String subject, String text) {

		System.out.println("Came");

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("mutturajdeval92@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		ExecutorService exe = Executors.newSingleThreadExecutor();
		
		//exe.submit(task)

		exe.execute(new Runnable() {

			@Override
			public void run() {
				emailSender.send(message);

			}
		});

		exe.isShutdown();
		exe.shutdown();
	}
}
