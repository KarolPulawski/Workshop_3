package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {""})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = UserDao.loadAllByGroupId(1);
        } catch (Exception e) {
            e.printStackTrace();

        }

        for(User user : users) {
            System.out.println(user.getUser_group_id());
            System.out.println(user.getId());
            System.out.println(user.getPassword());
            System.out.println(user.getEmail());
        }

        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request,response);
    }
}
