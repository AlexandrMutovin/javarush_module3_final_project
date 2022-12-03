package ru.javarush.amutovin.module3.UserRepo;

import lombok.Getter;
import lombok.Setter;



public class User {
    @Getter
    @Setter
    private String userName;
    private int currentStep;
    private int allCountOfGames;
    private int failedCountGames;
    private int successfulGames;

}
