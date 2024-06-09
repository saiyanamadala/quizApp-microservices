package com.quizApp.question_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionWrapper {

    private Integer id;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String question_title;

    public QuestionWrapper(String option4, Integer id, String option1, String option2, String option3, String question_title) {
        this.option4 = option4;
        this.id = id;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.question_title = question_title;
    }
}
