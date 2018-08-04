package pl.coderslab.dao;

import pl.coderslab.entity.Group;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupDao {

    public static Group loadById(int id) throws Exception {

        String query = "SELECT * FROM user_group WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        Group group = null;
        List<Map<String, String>> data = DbService.getData(query, params);
        for (Map<String, String> row : data) {
            group = createNewGroup(row);
        }
        return group;
    }

    public static List<Group> loadAll() throws Exception{
        String query = "SELECT * FROM user_group";
        List<Group> groups = new ArrayList<>();

        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String, String> row : data) {
            groups.add(createNewGroup(row));
        }
        return groups;
    }

    private static Group createNewGroup(Map<String, String> row) {
        Group group = new Group();
        group.setId(Integer.parseInt(row.get("id")));
        group.setName(row.get("name"));
        return group;
    }

    public static void delete(Group group) throws Exception {
        String query = "DELETE FROM user_group WHERE id=?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(group.getId()));
        DbService.executeQuery(query,params);
        group.setId(0);
    }

    public static void save(Group group) throws Exception {
        if(group.getId() == null) {
            add(group);
        } else {
            update(group);
            return;
        }
    }

    private static void add(Group group) throws Exception {
        String query = "INSERT INTO user_group VALUES(null,?)";
        List<String> params = new ArrayList<>();
        params.add(group.getName());

        Integer id = DbService.insertIntoDatabase(query, params);
        group.setId(id);
    }

    private static void update(Group group) throws Exception {
        String query = "UPDATE user_group SET name = ? " +
                "WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(group.getName());
        params.add(String.valueOf(group.getId()));

        DbService.executeQuery(query, params);
    }
}
