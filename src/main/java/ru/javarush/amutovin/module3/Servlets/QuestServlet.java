package ru.javarush.amutovin.module3.Servlets;

import ru.javarush.amutovin.module3.UserRepo.User;
import ru.javarush.amutovin.module3.UserRepo.UserRepo;
import ru.javarush.amutovin.module3.quests.Quest;
import ru.javarush.amutovin.module3.quests.Question;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestServlet extends HttpServlet {
    Quest quest;
    UserRepo userRepo;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
         quest = (Quest)config.getServletContext().getAttribute("quest");
        userRepo = (UserRepo) config.getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("start");
            return;
        }
        String nextQuestion = req.getParameter("nextQuestion");
        String endQuest = req.getParameter("endQuest");
        if (nextQuestion != null) {
            Question question = quest.getNextQuestion(Integer.parseInt(nextQuestion));
            user.setQuestion(question);
            user.setQuestion(question);
            user.setIpAddress(req.getRemoteAddr());
            if (endQuest != null) {
                if (endQuest.equals("true")) {
                    user.setSuccessfulQuest(user.getSuccessfulQuest() + 1);
                }
            }


            userRepo.addUser(user.getUserName(), user);

        }

        req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
    }
}
