package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.Solution;
import pl.coderslab.entity.User;
import pl.coderslab.service.DateService;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Solution> solutions = null;
        try {
            solutions = SolutionDao.loadAll(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request, response);
    }
}
