package pl.coderslab.entity;

import java.sql.Date;

public class Solution {

    private Integer id;
    private Date created;
    private Date updated;
    private String description;
    private Integer exercise_id;
    private Integer users_id;

    public Solution(Date created, Date updated, String description, Integer exercise_id, Integer users_id) {
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
    }

    public Solution() {
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
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
