package service;


import Dao.QuizDao;
import entity.QuestionWrapper;
import entity.Quiz;
import entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

//    @Autowired
//    QuestionDao qDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//        List<Integer> questions=
//        Quiz quiz=new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quiz=quizDao.findById(id);
//        List<Question> questionsFromDB=quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser=new ArrayList<>();
//        for(Question q:questionsFromDB){
//            QuestionWrapper qw=new QuestionWrapper(q.getOption4(),q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getQuestion_title());
//            questionsForUser.add(qw);
//        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
        Quiz quiz=quizDao.findById(id).get();
//        List<Question> questions=quiz.getQuestions();
       int right=0;
//        int i=0;
//        for(Response res: response){
//            if(res.getResponse().equals(questions.get(i).getRight_answer()))
//                right++;
//            i++;
//        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
