package pl.coderslab.controller.manager.group;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupManagerDelete", urlPatterns = {"/groupDelete"})
public class GroupManagerDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("groupId"));
        Group group = new Group();
        group.setId(id);
        try {
            GroupDao.delete(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("panelAdminGroup");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
