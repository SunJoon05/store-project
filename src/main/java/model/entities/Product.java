package model.entities;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Market market;

    public Product(Integer id, String name, Double price, Market market) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.market = market;
    }

    public Product() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

