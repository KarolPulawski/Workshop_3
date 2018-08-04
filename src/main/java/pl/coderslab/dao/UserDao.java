package pl.coderslab.dao;

import pl.coderslab.entity.User;
import pl.coderslab.service.DbService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {

    public static List<User> loadAllByGroupId(int groupId) throws Exception {

        String query = "SELECT * FROM users WHERE user_group_id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(groupId));
        List<User> users = new ArrayList<>();

        List<Map<String, String>> data = DbService.getData(query, params);
        for(Map<String, String> row : data) {
            createNewUser(users, row);
        }
        return users;
    }

    public static User loadById(Integer id) throws Exception {
        String query = "SELECT * FROM users WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        List<User> users = new ArrayList<>();

        List<Map<String, String>> data = DbService.getData(query, params);
        for(Map<String, String> row : data) {
            createNewUser(users, row);
        }
        return users.get(0);
    }

    public static List<User> loadAll() throws Exception{
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String, String> row : data) {
            createNewUser(users, row);
        }
        return users;
    }

    private static void createNewUser(List<User> users, Map<String, String> row) {
        User user = new User();
        user.setId(Integer.parseInt(row.get("id")));
        user.setUsername(row.get("username"));
        user.setEmail(row.get("email"));
        user.setPassword(row.get("password"));
        user.setUser_group_id(Integer.parseInt(row.get("user_group_id")));
        users.add(user);
    }

    public static void save(User user) throws Exception {
        if(user.getId() == null) {
            add(user);
        } else {
            update(user);
            return;
        }
    }

    public static void delete(User user) throws Exception {
        String query = "DELETE FROM users WHERE id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(user.getId()));
        DbService.executeQuery(query,params);
        user.setId(0);
    }

    private static void update(User user) throws Exception {
        String query = "UPDATE users SET username = ?, " +
                "email = ?, password = ?, user_group_id = ? " +
                "WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(user.getUsername());
        params.add(user.getEmail());
        params.add(user.getPassword());
        params.add(String.valueOf(user.getUser_group_id()));
        params.add(String.valueOf(user.getId()));

        DbService.executeQuery(query, params);
    }

    private static void add(User user) throws Exception {
        String query = "INSERT INTO users VALUES(null,?,?,?,?)";
        List<String> params = new ArrayList<>();
        params.add(user.getUsername());
        params.add(user.getEmail());
        params.add(user.getPassword());
        params.add(String.valueOf(user.getUser_group_id()));

        Integer id = DbService.insertIntoDatabase(query, params);
        user.setId(id);
    }
}
