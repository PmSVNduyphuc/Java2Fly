package Books.Dao;

import Connection.Entityes.Product;

import java.sql.SQLException;
import java.util.List;

public interface DaoProduct {
        public int insert(Product product) throws SQLException;
        public int save(Product product) throws SQLException;

        public List<Product> getAll() throws SQLException;

}

