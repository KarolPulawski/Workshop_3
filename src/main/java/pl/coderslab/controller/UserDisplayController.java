package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Solution;
import pl.coderslab.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDisplayController", urlPatterns = {"/displayUser"})
public class UserDisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer group_id;
        List<User> users = null;
        List<Solution> solutions = null;
        try {
            group_id = Integer.parseInt(request.getParameter("group_id"));
            users = UserDao.loadAllByGroupId(group_id);
            solutions = SolutionDao.loadAll();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/META-INF/views/displayUser.jsp").forward(request, response);

    }
}
