package ru.javarush.amutovin.module3.repository;


import java.util.HashMap;

public class UserRepo {
    private static UserRepo instance;

    private HashMap<String, User> userMap = new HashMap<String, User>();

    public User getUser(String userName) {
        return userMap.get(userName);
    }

    public boolean isExistUser(String userName) {
        return userMap.containsKey(userName);
    }

    public void addUser(String userName, User user){
        userMap.put(userName, user);
    }

}
