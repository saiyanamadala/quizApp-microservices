package com.quizApp.question_service.controller;


import com.quizApp.question_service.entity.Question;
import com.quizApp.question_service.entity.QuestionWrapper;
import com.quizApp.question_service.entity.Response;
import com.quizApp.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController {

    @Autowired
    QuestionService qserv;

    @Autowired
    Environment environment;

    @GetMapping("test")
    public void getTest(){
        System.out.println("Test");
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> allQuestions(){
        System.out.println(environment.getProperty("local.server.port"));
        return qserv.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return qserv.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return qserv.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){
        return qserv.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        return qserv.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return qserv.getScore(responses);
    }


}
