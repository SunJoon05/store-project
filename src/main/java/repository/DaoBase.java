package repository;

import java.sql.SQLException;
import java.util.List;

// the methods must common in SQL
/*
T => represents an any object <Users, Product, etc.> we
ID => represents the data type of the primary key
if you need a more specific methods, you can create those methods in other scope context,
for example you want the findByID method, you implement generic interface and create a SpecificDao with that method :D
 */
public interface DaoBase<T, ID>{
    List<T> findAll() throws SQLException, ClassNotFoundException;
    Boolean insert(T entity) throws SQLException, ClassNotFoundException;
    Boolean update(T entity) throws SQLException, ClassNotFoundException;
    Boolean delete(ID id) throws SQLException, ClassNotFoundException;
}