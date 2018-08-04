package pl.coderslab.entity;

public class Group {

    private Integer id;
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public Group() {}

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
