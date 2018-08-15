package pl.coderslab.controller.manager.user;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserManagerDelete", urlPatterns = {"/userDelete"})
public class UserManagerDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        User user = new User();
        user.setId(id);
        try {
            UserDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
