package com.cognizant.hqlquiz.service;

import com.cognizant.hqlquiz.model.Attempt;
import com.cognizant.hqlquiz.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Transactional
    public Attempt getAttempt(int userId, int attemptId) {
        Attempt attempt = attemptRepository.getAttempt(userId, attemptId);
        return attempt;
    }
}
