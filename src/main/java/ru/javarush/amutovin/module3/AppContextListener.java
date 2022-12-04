package ru.javarush.amutovin.module3;

import ru.javarush.amutovin.module3.UserRepo.User;
import ru.javarush.amutovin.module3.UserRepo.UserRepo;
import ru.javarush.amutovin.module3.quests.Quest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("userRepository", new UserRepo());
        context.setInitParameter("requestEncoding", "UTF-8");
        context.setAttribute("quest", new Quest());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
