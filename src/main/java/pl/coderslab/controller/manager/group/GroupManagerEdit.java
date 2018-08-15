package pl.coderslab.controller.manager.group;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupManagerEdit", urlPatterns = {"/groupEdit"})
public class GroupManagerEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupName = request.getParameter("groupName");
        Integer groupId = Integer.parseInt(request.getParameter("groupId"));
        Group group = new Group();
        group.setId(groupId);
        group.setName(groupName);
        try {
            GroupDao.save(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("groupId"));
        request.setAttribute("groupId", id);
        getServletContext().getRequestDispatcher("/META-INF/views/group/groupFormEdit.jsp").forward(request, response);
    }
}
