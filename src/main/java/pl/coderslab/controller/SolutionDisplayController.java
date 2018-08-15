package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SolutionDisplayController", urlPatterns = {"/displaySolution"})
public class SolutionDisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Solution> solutions = null;
        try {
            int id = Integer.parseInt(request.getParameter("user_id"));
            solutions = SolutionDao.loadAllByUserId(id);
            request.setAttribute("solutions", solutions);
            getServletContext().getRequestDispatcher("/META-INF/views/displaySolution.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
