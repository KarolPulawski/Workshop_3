package pl.coderslab.controller.manager.user;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserManagerView", urlPatterns = {"/panelAdminUser"})
public class UserManagerView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = null;
        try {
            users = UserDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/META-INF/views/user/userDisplay.jsp").forward(request, response);
    }
}
