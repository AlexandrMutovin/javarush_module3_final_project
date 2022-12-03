package ru.javarush.amutovin.module3.Servlets;

import ru.javarush.amutovin.module3.UserRepo.User;
import ru.javarush.amutovin.module3.UserRepo.UserRepo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
public class AppServlet extends HttpServlet {
    UserRepo userRepo = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
         userRepo = (UserRepo) config.getServletContext().getAttribute("userRepository");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            resp.sendRedirect("quest");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post===========");
        String userName  = req.getParameter("username");
        if (userName == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);
            return;
        }

        User user;
        if (userRepo.isExistUser(userName)) {
            user = userRepo.getUser(userName);
        } else {
            user = new User();
            user.setUserName(userName);
            userRepo.addUser(userName, user);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("quest");
        }
    }

}
