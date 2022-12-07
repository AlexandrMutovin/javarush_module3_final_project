package ru.javarush.amutovin.module3.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.amutovin.module3.repository.User;
import ru.javarush.amutovin.module3.repository.UserRepo;
import ru.javarush.amutovin.module3.quests.Quest;
import ru.javarush.amutovin.module3.quests.Question;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(QuestServlet.class);
    private static final String RESET_COUNT_ANSWER_WHEN_FINISH = "6";
    private static final Integer START_COUNT_TRUE_ANSWERS = 0;
    Quest quest;
    UserRepo userRepo;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        quest = (Quest) config.getServletContext().getAttribute("quest");
        LOGGER.debug("Загрузили квест");
        userRepo = (UserRepo) config.getServletContext().getAttribute("userRepository");
        LOGGER.debug("Загрузили репозиторий");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            LOGGER.debug("Сессия пользователя не установлена. Редирект на страницу авторизации");
            resp.sendRedirect("start");
            return;
        }
        String nextQuestion = req.getParameter("nextQuestion");
        String trueAnswer = req.getParameter("trueAnswer");
        String finish = req.getParameter("finish");
        if (nextQuestion != null) {
            LOGGER.debug("Берем следующий вопрос");
            Question question = quest.getNextQuestion(Integer.parseInt(nextQuestion));
            user.setQuestion(question);
            user.setQuestion(question);
            user.setIpAddress(req.getRemoteAddr());
            if (nextQuestion.equals(RESET_COUNT_ANSWER_WHEN_FINISH)){
                user.setCountTrueAnswers(START_COUNT_TRUE_ANSWERS);
            }
            if (trueAnswer != null) {
                if (trueAnswer.equals("true")) {
                    LOGGER.debug("Увеличиваем счетчик правильных ответов");
                    user.setCountTrueAnswers(user.getCountTrueAnswers() + 1);
                }
            }
            if (finish != null) {
                if (finish.equals("true")){
                    user.setSuccessfulQuest(1);
                }
            }

                userRepo.addUser(user.getUserName(), user);

        }

        req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
    }
}
