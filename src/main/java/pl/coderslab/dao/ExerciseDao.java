package pl.coderslab.dao;

import pl.coderslab.entity.Exercise;
import pl.coderslab.service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseDao {

    public static Exercise loadById(Integer id) throws Exception {
        String query = "SELECT * FROM exercise WHERE id = ? ";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));
        List<Map<String, String>> data = DbService.getData(query, params);
        Exercise exercise = null;
        for(Map<String, String> row : data) {
            exercise = createNewExercise(row);
        }
        return exercise;
    }

    public static List<Exercise> loadAll() throws Exception{
        String query = "SELECT * FROM exercise";
        List<Exercise> exercises = new ArrayList<>();
        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String, String> row : data) {
            exercises.add(createNewExercise(row));
        }
        return exercises;
    }

    private static Exercise createNewExercise(Map<String, String> row) {
        Exercise exercise = new Exercise();
        exercise.setId(Integer.parseInt(row.get("id")));
        exercise.setTitle(row.get("title"));
        exercise.setDescription(row.get("description"));
        return exercise;
    }

    public static void delete(Exercise exercise) throws Exception {
        String query = "DELETE FROM exercise WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(exercise.getId()));
        DbService.executeQuery(query, params);
        exercise.setId(0);
    }

    public static void save(Exercise exercise) throws Exception {
        if(exercise.getId() == null) {
            add(exercise);
        } else {
            update(exercise);
            return;
        }
    }

    private static void update(Exercise exercise) throws Exception {
        String query ="UPDATE exercise SET title = ?, description = ? WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(exercise.getTitle());
        params.add(exercise.getDescription());
        params.add(String.valueOf(exercise.getId()));
        DbService.executeQuery(query, params);
    }

    private static void add(Exercise exercise) throws Exception {
        String query = "INSERT INTO exercise VALUES(null, ?,?)";
        List<String> params = new ArrayList<>();
        params.add(exercise.getTitle());
        params.add(exercise.getDescription());
        Integer id = DbService.insertIntoDatabase(query, params);
        exercise.setId(id);
    }
}
