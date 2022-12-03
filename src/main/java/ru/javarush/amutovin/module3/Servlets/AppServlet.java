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
        System.out.println("====init======");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        if (userName != null){
            //resp.sendRedirect("quest");
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
            return;
        }
        System.out.println("fefee");
        User user;
        if (userRepo.isExistUser(userName)){
            req.setAttribute("userName", userName);
            System.out.println("fefee111111111111");
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }
        req.setAttribute("userName", "Юзера нету");
        System.out.println("fefee222222222222");

        getServletContext().getRequestDispatcher("/WEB-INF/start.jsp").forward(req, resp);

        
    }
}
