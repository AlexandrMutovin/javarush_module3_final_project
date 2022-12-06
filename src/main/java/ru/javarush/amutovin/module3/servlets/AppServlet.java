package ru.javarush.amutovin.module3.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.amutovin.module3.repository.User;
import ru.javarush.amutovin.module3.repository.UserRepo;
import ru.javarush.amutovin.module3.quests.Quest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AppServlet extends HttpServlet {
    private static final Integer START_COUNT_TRUE_ANSWERS = 0;
    private static final Integer START_COUNT_SUCCESSFUL_QUEST = 0;
    private static final Logger LOGGER = LogManager.getLogger(AppServlet.class);
    UserRepo userRepo;
    Quest quest;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userRepo = (UserRepo) config.getServletContext().getAttribute("userRepository");
        LOGGER.debug("Получили репозиторий");
        quest = (Quest)config.getServletContext().getAttribute("quest");
        LOGGER.debug("Загрузили квест");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LOGGER.debug("Получили сессию");
        User user = (User) session.getAttribute("user");
        if (user != null) {
            LOGGER.debug("Пользователь в сессии найден, редирект на квест");
            resp.sendRedirect("quest");
            return;
        }
        LOGGER.debug("Пользователь в сессии не найден, редирект на страницу авторизации");
        getServletContext().getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        if (userName == null) {
            LOGGER.debug("Имя пользователя не установлено в Post запросе, переход на страницу авторизации");
            getServletContext().getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);
            return;
        }

        User user;
        if (userRepo.isExistUser(userName)) {
            LOGGER.debug("Пользователь найден в репозитории");
            user = userRepo.getUser(userName);
        } else {
            LOGGER.debug("Пользователь в репозитории не найден, создание нового ользователя");
            user = new User();
            user.setUserName(userName);
            user.setQuestion(quest.getNextQuestion(0));
            user.setSuccessfulQuest(START_COUNT_SUCCESSFUL_QUEST);
            user.setCountTrueAnswers(START_COUNT_TRUE_ANSWERS);
            user.setIpAddress(req.getRemoteAddr());
            userRepo.addUser(userName, user);

            HttpSession session = req.getSession();
            LOGGER.debug("Установка пользователя в сессию");
            session.setAttribute("user", user);
            LOGGER.debug("Редирект на страницу квеста");
            resp.sendRedirect("quest");
        }
    }

}
