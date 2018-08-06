package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GroupDisplayController", urlPatterns = {"/displayGroup"})
public class GroupDisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = null;
        try {
            groups = GroupDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/META-INF/views/displayGroup.jsp").forward(request, response);

    }
}
