package ru.javarush.amutovin.module3.repository;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.amutovin.module3.quests.Question;


public class User {
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private Integer currentStep;
    @Getter
    @Setter
    private Integer successfulQuest;
    @Getter
    @Setter
    private String ipAddress;
    @Getter
    @Setter
    private Question question;
    @Getter
    @Setter
    private Integer countTrueAnswers;
}
