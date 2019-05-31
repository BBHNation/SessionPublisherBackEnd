package com.hancock.SessionPublisher;

import com.hancock.SessionPublisher.intrastructure.session.SessionRepository;
import com.hancock.SessionPublisher.session.SessionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionPublisherApplication {

    @Autowired SessionRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SessionPublisherApplication.class, args);
	}

}
