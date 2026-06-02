package model.entities;

import java.util.List;

public class Market {
    private Integer id;
    private String name;
    private User supervisor;
    private List<Product> products;

    public Market(int id, String name, User supervisor, List<Product> products) {
        this.id = id;
        this.name = name;
        this.supervisor = supervisor;
        this.products = products;
    }

    public Market() {
        this.id = null;
        this.name = null;
        this.supervisor = null;
        this.products = null;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public User getSupervisor() {return supervisor;}

    public void setSupervisor(User supervisor) {this.supervisor = supervisor;}

    public List<Product> getProducts() {return products;}

    public void setProducts(List<Product> products) {this.products = products;}
}
