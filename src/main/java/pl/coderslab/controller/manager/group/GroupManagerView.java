package pl.coderslab.controller.manager.group;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupManagerView", urlPatterns = {"/panelAdminGroup"})
public class GroupManagerView extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/META-INF/views/groupDisplay.jsp").forward(request, response);

    }
}
