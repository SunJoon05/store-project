package model.entities;

public class Permission {

    private int id;
    private String name;
    private String resource;
    private String action;

    public Permission(int id, String name, String resource, String action) {
        this.name = name;
        this.resource = resource;
        this.action = action;
    }
}
