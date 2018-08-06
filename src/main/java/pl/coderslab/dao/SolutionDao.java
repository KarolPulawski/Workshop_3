package pl.coderslab.dao;

import pl.coderslab.entity.Solution;
import pl.coderslab.service.DbService;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionDao {

    public static ArrayList<Solution> loadByUserIdByExerciseId(int userId, int exerciseId) throws Exception {
        String query = "SELECT solution.id AS id, solution.created AS created, solution.updated AS updated, solution.description AS description, " +
                "solution.exercise_id AS exercise_id, solution.users_id AS users_id FROM " +
                "exercise " +
                "LEFT JOIN solution ON exercise.id = solution.exercise_id " +
                "WHERE solution.users_id = ? AND solution.exercise_id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(userId));
        params.add(String.valueOf(exerciseId));
        List<Map<String, String>> data = DbService.getData(query, params);
        ArrayList<Solution> solutions = new ArrayList<>();
        for(Map<String, String> row : data) {
            solutions.add(createNewSolution(row));
        }
        return solutions;
    }

    public static ArrayList<Solution> loadAllByUserId(int id) throws Exception {
        String query = "SELECT * FROM solution WHERE users_id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DbService.getData(query, params);
        ArrayList<Solution> solutions = new ArrayList<>();
        for(Map<String, String> row : data) {
            solutions.add(createNewSolution(row));
        }
        return solutions;
    }

    public static List<Solution> loadAll() throws Exception {
        String query = "SELECT * FROM solution";
        List<Map<String, String>> data = DbService.getData(query, null);
        List<Solution> solutions = new ArrayList<>();
        for (Map<String, String> row : data) {
            solutions.add(createNewSolution(row));
        }
        return solutions;
    }

    private static Solution createNewSolution(Map<String, String> row) throws ParseException {
        Solution solution = new Solution();
        solution.setId(Integer.parseInt(row.get("id")));

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

        String stringCreated = row.get("created");
        String stringUpdated = row.get("updated");

        if(stringUpdated == null) stringUpdated = "0000-00-00";

        java.util.Date created = formatter.parse(stringCreated);
        java.util.Date updated = formatter.parse(stringUpdated);
        Date createdSql = new Date(created.getTime());
        Date updateSql = new Date(updated.getTime());

        solution.setCreated(createdSql);
        solution.setUpdated(updateSql);


        String description = row.get("description");
        if(description == null) description = "---------";
        solution.setDescription(description);

        solution.setExercise_id(Integer.parseInt(row.get("exercise_id")));
        solution.setUsers_id(Integer.parseInt(row.get("users_id")));
        return solution;
    }

    public static void delete(Solution solution) throws Exception {
        String query = "DELETE FROM solution WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(solution.getId()));
        DbService.executeQuery(query, params);
    }

    public static void save(Solution solution) throws Exception {
        if(solution.getId() == null) {
            add(solution);
        } else {
            update(solution);
            return;
        }
    }

    private static void update(Solution solution) throws Exception {
        String query = "UPDATE solution SET updated = ?, description = ? WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(solution.getUpdated().toString());
        params.add(solution.getDescription());
        params.add(String.valueOf(solution.getId()));
        DbService.executeQuery(query, params);
    }

    private static void add(Solution solution) throws Exception {
        String query = "INSERT INTO solution VALUES(null,?,null, null, ?,?)";
        List<String> params = new ArrayList<>();
        params.add(solution.getCreated().toString());
        params.add(String.valueOf(solution.getExercise_id()));
        params.add(String.valueOf(solution.getUsers_id()));
        Integer id = DbService.insertIntoDatabase(query, params);
        solution.setId(id);
    }


}
