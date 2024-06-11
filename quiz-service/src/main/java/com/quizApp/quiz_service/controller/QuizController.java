package com.quizApp.quiz_service.controller;


import com.quizApp.quiz_service.entity.QuestionWrapper;
import com.quizApp.quiz_service.entity.QuizDto;
import com.quizApp.quiz_service.entity.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quizApp.quiz_service.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {

    //@Autowired
    QuizService quizServ;

    public QuizController(QuizService quizServ) {
        this.quizServ = quizServ;
    }

    @GetMapping("test")
    public String getTest(){
        return "test";
    }

    //@PostMapping("create?category={Category}&numQ={numQ}&title={title}")
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto ){  //DTO= Data Transfer Object
//        return new ResponseEntity<>("Good", HttpStatus.OK);

        return quizServ.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizServ.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizServ.calculateResult(id,response);
    }
}

