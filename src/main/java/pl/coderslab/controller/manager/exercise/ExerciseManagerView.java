package pl.coderslab.controller.manager.exercise;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExerciseManagerView", urlPatterns = {"/panelAdminExercise"})
public class ExerciseManagerView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exercise> exercises = null;
        try {
            exercises = ExerciseDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/META-INF/views/exercise/exerciseDisplay.jsp").forward(request, response);

    }
}
