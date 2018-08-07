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

@WebServlet(name = "ExerciseDisplayController", urlPatterns = {"/displayExercise"})
public class ExerciseDisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercise exercise = null;
        Integer exercise_id = null;
        try {
            exercise_id = Integer.parseInt(request.getParameter("exercise_id"));
            exercise = ExerciseDao.loadById(exercise_id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Solution> solutions = null;
        try {
            solutions = SolutionDao.loadByExerciseId(exercise_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<User> users = null;
        try {
            users = UserDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("exercise", exercise);
        request.setAttribute("solutions", solutions);
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/META-INF/views/displayExercise.jsp").forward(request, response);
//        request.setAttribute("solutions", solutions);
    }
}
