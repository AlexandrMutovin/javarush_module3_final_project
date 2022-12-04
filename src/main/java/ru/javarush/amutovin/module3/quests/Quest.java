package ru.javarush.amutovin.module3.quests;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quest {
    private List<Question> replicas = new ArrayList<>();

    public Quest(){
        replicas.add(new Question(0, "Вы Знакомы с языком програмирования Java?",
                List.of(new Question.Answers("Я знаком", 2,false),
                        new Question.Answers("Нет, слышу в первый раз", 1,false))));
        replicas.add(new Question(1, "Желаете выучить язык программирования Java?",
                List.of(new Question.Answers("Желаю", 2,false),
                        new Question.Answers("Нет, не желаю", 5,false))));
        replicas.add(new Question(2, "Какой курс желаете пройти?",
                List.of(new Question.Answers("Junior", 3,false),
                        new Question.Answers("Middle", 3,false),
                        new Question.Answers("Senior", 3,false))));
        replicas.add(new Question(3, "Выберите время обучения",
                List.of(new Question.Answers("Утренняя группа", 4,true),
                        new Question.Answers("Дневная группа", 4,true),
                        new Question.Answers("Вечерняя группа", 4,true),
                        new Question.Answers("Группа выходно дня", 4,true),
                        new Question.Answers("Время не подходит", 5,false))));
        replicas.add(new Question(4, "Вы записаны на курс. Желаем успешного обучения",
                List.of(new Question.Answers("Пройти тест еще раз", 0,false))));
        replicas.add(new Question(5, "Ждем вас в следующий раз, спасибо!",
                List.of(new Question.Answers("Записаться на курс повторно?", 0,false))));



    }
    public Question getNextQuestion(int id) {
        return replicas.stream()
                .filter(s -> s.getQuestionId() == id)
                .findFirst().get();

    }
}
