package com.cognizant.hqlquiz;

import com.cognizant.hqlquiz.model.Attempt;
import com.cognizant.hqlquiz.model.AttemptOption;
import com.cognizant.hqlquiz.model.AttemptQuestion;
import com.cognizant.hqlquiz.model.Options;
import com.cognizant.hqlquiz.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class HqlQuizApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(HqlQuizApplication.class);

	@Autowired
	private AttemptService attemptService;

	public static void main(String[] args) {
		SpringApplication.run(HqlQuizApplication.class, args);
	}

	private void testGetAttempt() {
		// TODO Auto-generated method stub
		LOGGER.info("Fetch Question Attempts");
		Attempt attempt = attemptService.getAttempt(1, 1);
		for (AttemptQuestion attemptQuestion : attempt.getAttemptQuestionList()) {
			LOGGER.debug("{}, yes", attemptQuestion.getQuestion().getText());
			int i = 1;
			for (AttemptOption attemptOption : attemptQuestion.getAttemptOptionList()) {
				Options option = attemptOption.getOption();
				LOGGER.debug("{}) {} {} {}", i, String.format("%-10s" ,option.getText()), String.format("%-7.1f", option.getScore()), attemptOption.isSelected());
				++i;
			}
		}
		LOGGER.info("Fetch-Completed");
	}

	@Override
	public void run(String... args) throws Exception {
		testGetAttempt();
	}
}
