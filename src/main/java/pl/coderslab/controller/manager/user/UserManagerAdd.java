package pl.coderslab.controller.manager.user;

import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserManagerAdd", urlPatterns = {"/userAdd"})
public class UserManagerAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setUsername(request.getParameter("userName"));
        try {
            user.setUser_group_id(Integer.parseInt(request.getParameter("userGroupId")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("userEmail"));
        user.setPassword(request.getParameter("userPassword"));
        try {
            UserDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminUser");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
