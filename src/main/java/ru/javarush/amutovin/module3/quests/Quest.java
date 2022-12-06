package ru.javarush.amutovin.module3.quests;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    private List<Question> replicas = new ArrayList<>();

    public Quest(){
        replicas.add(new Question(0, "Вы Знакомы с языком програмирования Java?",
                List.of(new Question.Answers("Я знаком", 2,false, false),
                        new Question.Answers("Нет, слышу в первый раз", 1,false,false))));
        replicas.add(new Question(1, "Желаете выучить язык программирования Java?",
                List.of(new Question.Answers("Желаю", 2,false,false),
                        new Question.Answers("Нет, не желаю", 5,false,false))));
        replicas.add(new Question(2, "Какой курс желаете пройти?",
                List.of(new Question.Answers("Junior", 3,false, false),
                        new Question.Answers("Middle", 3,false, false),
                        new Question.Answers("Senior", 3,false,false))));
        replicas.add(new Question(3, "Выберите время обучения",
                List.of(new Question.Answers("Утренняя группа", 14,false,false),
                        new Question.Answers("Дневная группа", 14,false,false),
                        new Question.Answers("Вечерняя группа", 14,false, false),
                        new Question.Answers("Группа выходно дня", 14,false,false),
                        new Question.Answers("Время не подходит", 4,false, true))));
        replicas.add(new Question(4, "Вы записаны на курс. Желаем успешного обучения",
                List.of(new Question.Answers("Пройти тест еще раз", 0,false, false))));
        replicas.add(new Question(5, "Ждем вас в следующий раз, спасибо!",
                List.of(new Question.Answers("Записаться на курс?", 0,false,false))));

        replicas.add(new Question(6, "Как правильно объявить массив?",
                List.of(new Question.Answers(" int a = new int[] {1, 2, 3, 4, 5};", 7,false,false),
                        new Question.Answers(" int[] a = new int[] {1, 2, 3, 4, 5};", 7,true,false),
                        new Question.Answers(" int[] a = new int {1, 2, 3, 4, 5};", 7,false,false),
                        new Question.Answers(" int a[] = 1, 2, 3, 4, 5;", 7,false,false))));

        replicas.add(new Question(7, "Тернарный оператор это:",
                List.of(new Question.Answers("&&", 8,false,false),
                        new Question.Answers("!", 8,false,false),
                        new Question.Answers("^", 8,false,false),
                        new Question.Answers(" ? :", 8,true,false))));

        replicas.add(new Question(8, "Как объявить класс в коде?",
                List.of(new Question.Answers("class MyClass {}", 9,true,false),
                        new Question.Answers("new class MyClass {}", 9,false,false),
                        new Question.Answers("select * from class MyClass {}", 9,false,false),
                        new Question.Answers("MyClass extends class {}", 9,false,false))));

        replicas.add(new Question(9, "Чем отличаются static-метод класса от обычного метода класса?",
                List.of(new Question.Answers("поведение обычного метода класса можно изменить в классе-наследнике, а поведение static-метода нельзя", 10,false,false),
                        new Question.Answers("обычный метод класса можно переопределить, а static-метод нельзя", 10,false,false),
                        new Question.Answers("обычный метод класса работает от объекта класса, а static-метод от всего класса", 10,true,false),
                        new Question.Answers("static-метод класса можно вызывать только внутри класса, а обычный - в любой части кода", 10,false,false))));

        replicas.add(new Question(10, "Как вызвать обычный метод класса внутри static-метода?",
                List.of(new Question.Answers("никак, static-метод не работает с объектом класса", 11,true,false),
                        new Question.Answers("можно, надо перед этим перегрузить обычный метод класса", 11,true,false),
                        new Question.Answers("можно, надо перед этим переопределить обычный метод класса", 11,false,false),
                        new Question.Answers("можно, ничего дополнительно делать не надо", 11,false,false))));

        replicas.add(new Question(11, "Для чего используется ключевое слово «this»?",
                List.of(new Question.Answers("указатель на переопределенный метод класса", 12,false,false),
                        new Question.Answers("указатель на текущий объект класса внутри самого класса", 12,true,false),
                        new Question.Answers("это не ключевое слово", 12,false,false),
                        new Question.Answers("ключевое слово для вызова обычного метода внутри static-метода", 12,false,false))));

        replicas.add(new Question(12, "Чем является ключевое слово «public»?",
                List.of(new Question.Answers("литералом", 13,false,true),
                        new Question.Answers("оператором", 13,false,true),
                        new Question.Answers("модификатором доступа", 13,true,true),
                        new Question.Answers("типом данных", 13,false,true))));

        replicas.add(new Question(13, "Вы завершили тест и записаны на курс, результаты можно посмотреть в статистике",
                List.of(new Question.Answers("Пройти тест еще раз", 6,false,false))));

        replicas.add(new Question(14, "Желаете пройти тестирование?",
                List.of(new Question.Answers("Да", 6,false,false),
                new Question.Answers("Нет", 4,false,true))));

    }
    public Question getNextQuestion(int id) {
        return replicas.stream()
                .filter(s -> s.getQuestionId() == id)
                .findFirst().get();

    }
}
