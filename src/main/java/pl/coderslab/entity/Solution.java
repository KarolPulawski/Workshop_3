package pl.coderslab.entity;

import java.sql.Timestamp;

public class Solution {

    private Integer id;
    private Timestamp created;
    private Timestamp updated;
    private String description;
    private Integer exercise_id;
    private Integer users_id;

    public Solution(Timestamp created, Timestamp updated, String description, Integer exercise_id, Integer users_id) {
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
    }

    public Solution() {
    }

    public void setCreated(Timestamp created) {
        if(created == null) this.created = new Timestamp(0);
        else this.created = created;
    }

    public void setUpdated(Timestamp updated) {
        if(updated == null) this.updated = new Timestamp(0);
        else this.updated = updated;
    }

    public void setDescription(String description) {
        if(description == null) this.description = "";
        else this.description = description;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public String getDescription() {
        return description;
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public Integer getUsers_id() {
        return users_id;
    }

}
