package ru.javarush.amutovin.module3.Servlets;

import ru.javarush.amutovin.module3.UserRepo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User )req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("start");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);

    }
}
