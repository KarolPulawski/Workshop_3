package pl.coderslab.controller.manager.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseManagerAdd", urlPatterns = {"/exerciseAdd"})
public class ExerciseManagerAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exercise exercise = new Exercise();
        exercise.setTitle(request.getParameter("exerciseTitle"));
        exercise.setDescription(request.getParameter("exerciseDescription"));
        try {
            ExerciseDao.save(exercise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminExercise");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
