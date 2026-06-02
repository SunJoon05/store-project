package service;

import model.entities.Product;
import repository.ProductRepo;

import java.sql.SQLException;

public class ProductService {

    private final ProductRepo DAO;

    public ProductService(ProductRepo DAO) {this.DAO = DAO;}

    public boolean insertProduct(Product entity) throws SQLException, ClassNotFoundException{
        return this.DAO.insert(entity);
    }
}
