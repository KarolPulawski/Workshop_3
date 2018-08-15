package pl.coderslab.controller.manager.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseManagerEdit", urlPatterns = {"/exerciseEdit"})
public class ExerciseManagerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer exerciseId = null;
        try {
            exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Exercise exercise = new Exercise();
        exercise.setId(exerciseId);
        exercise.setDescription(request.getParameter("exerciseDescription"));
        exercise.setTitle(request.getParameter("exerciseTitle"));
        try {
            ExerciseDao.save(exercise);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminExercise");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("exerciseId"));
        request.setAttribute("exerciseId", id);
        getServletContext().getRequestDispatcher("/META-INF/views/exercise/exerciseFormEdit.jsp").forward(request, response);
    }
}
