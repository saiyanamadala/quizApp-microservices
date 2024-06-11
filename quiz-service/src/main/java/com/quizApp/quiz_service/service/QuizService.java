package com.quizApp.quiz_service.service;


import com.quizApp.quiz_service.Dao.QuizDao;
import com.quizApp.quiz_service.feign.QuizInterface;
import com.quizApp.quiz_service.entity.QuestionWrapper;
import com.quizApp.quiz_service.entity.Quiz;
import com.quizApp.quiz_service.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz=quizDao.findById(id).get();
        List<Integer> questionIds= quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        ResponseEntity<Integer> score= quizInterface.getScore(response);
        return score;
    }
}
