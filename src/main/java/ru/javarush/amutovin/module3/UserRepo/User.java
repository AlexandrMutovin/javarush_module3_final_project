package ru.javarush.amutovin.module3.UserRepo;

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

}
