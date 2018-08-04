package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
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
//        List<Group> groups = null;
//        try {
//            groups = GroupDao.loadAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        for(Group  group : groups) {
//            System.out.println(group.getId());
//            System.out.println(group.getName());
//        }

        Group group = null;
//        group.setId(8);
        //group.setName("group from saturday modified");

        try {
            group = GroupDao.loadById(7);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(group.getId());
        System.out.println(group.getName());


        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request, response);
    }
}
