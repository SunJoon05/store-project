package repository;

import model.entities.Product;
import service.MarketService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static database.DataSource.getConnection;

public class ProductRepo implements ProductDao {
    private MarketService market_service;

    public ProductRepo(){
        MarketRepo MARKET_DAO = new MarketRepo();
        this.market_service = new MarketService(MARKET_DAO);
    }

    @Override
    public List<Product> findAll() throws SQLException, ClassNotFoundException{
        String query = "SELECT * FROM products WHERE state = true";
        List<Product> products = new ArrayList<Product>();

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setMarket(this.market_service.getMarketById(rs.getInt("market_id")));
                products.add(p);
            }
        }

        return products;
    }

    @Override
    public Boolean insert(Product entity) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO products (name, price, market_id) VALUES (?, ?, ?)";
        boolean result;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            pstmt.setInt(3, entity.getMarket().getId());
            result = pstmt.executeUpdate() > 0;
        }

        return result;
    }

    @Override
    public Boolean update(Product entity) throws SQLException, ClassNotFoundException {
        String query = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        boolean result;

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            pstmt.setInt(3, entity.getId());

            result = pstmt.executeUpdate() > 0;
        }

        return result;
    }

    @Override
    public Boolean delete(Integer product_id) throws SQLException, ClassNotFoundException {
        String query = "UPDATE products SET state = false WHERE id = ?";
        boolean result;

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, product_id);

            result = pstmt.executeUpdate() > 0;
        }

        return result;
    }
}
