package pl.coderslab.controller.manager.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseManagerDelete", urlPatterns = {"/exerciseDelete"})
public class ExerciseManagerDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("exerciseId"));
        Exercise exercise = new Exercise();
        exercise.setId(id);
        try {
            ExerciseDao.delete(exercise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminExercise");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
