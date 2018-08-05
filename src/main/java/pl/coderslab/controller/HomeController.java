package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entity.Exercise;
import pl.coderslab.entity.Group;
import pl.coderslab.entity.User;
import pl.coderslab.service.DbService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {""})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Exercise> exercises = null;
//        try {
//            exercises = ExerciseDao.loadAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        for(Exercise exercise : exercises) {
//            System.out.print(exercise.getId());
//            System.out.print(" | ");
//            System.out.print(exercise.getTitle());
//            System.out.print(" | ");
//            System.out.print(exercise.getDescription());
//            System.out.print("\n");
//        }

//        Exercise exercise = new Exercise();
//        exercise.setId(6);
//        exercise.setTitle("exercise from sunday");
//        exercise.setDescription("LAST UPDATED create dao exercise");
        try {
            Exercise exercise = ExerciseDao.loadById(4);
            System.out.print(exercise.getId());
            System.out.print(" | ");
            System.out.print(exercise.getTitle());
            System.out.print(" | ");
            System.out.print(exercise.getDescription());
            System.out.print("\n");

        } catch (Exception e) {
            e.printStackTrace();
        }



        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request, response);
    }
}
