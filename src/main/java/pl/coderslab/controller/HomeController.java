package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.Solution;
import pl.coderslab.entity.User;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {""})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> solutions = null;
        try {
            solutions = SolutionDao.loadByUserIdByExerciseId(3,2);
        } catch (Exception e) {
            e.printStackTrace();

        }

        for(Solution solution : solutions) {
            System.out.print(solution.getId());
            System.out.print(" | ");
            System.out.print(solution.getCreated());
            System.out.print(" | ");
            System.out.print(solution.getUpdated());
            System.out.print(" | ");
            System.out.print(solution.getDescription());
            System.out.print(" | ");
            System.out.print(solution.getExercise_id());
            System.out.print(" | ");
            System.out.print(solution.getUsers_id());
            System.out.print("\n");
        }

//        Solution solution = new Solution();
//        Date date = new Date();
//        java.sql.Date current = new java.sql.Date(date.getTime());
//        solution.setCreated(current);
//        solution.setDescription("THIS is solution from Monday");
//        solution.setId(35);
//        try {
//            SolutionDao.save(solution);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            Exercise exercise = ExerciseDao.loadById(4);
//            System.out.print(exercise.getId());
//            System.out.print(" | ");
//            System.out.print(exercise.getTitle());
//            System.out.print(" | ");
//            System.out.print(exercise.getDescription());
//            System.out.print("\n");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }





        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request, response);
    }
}
