package ru.javarush.amutovin.module3.quests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class Question {
    private Integer questionId;
    private String text;
    private List<Answers> answerList;

    @AllArgsConstructor
    @Getter
    @Setter
public static class Answers {
        private String text;
        private Integer nextQuestionId;
        private Boolean trueAnswer;


    }
}

