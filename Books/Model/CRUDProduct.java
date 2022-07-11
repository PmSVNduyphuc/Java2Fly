package Books.Model;


import Books.Dao.DaoProduct;
import Books.Entityes.Product;
import Books.Mssql.MssqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDProduct implements DaoProduct{
    Connection connection = MssqlConnection.getMssqlConnection();

    public CRUDProduct(Connection conn) throws SQLException {
        this.conn = conn;
    }

    public CRUDProduct() throws SQLException{
        super();
    }
    private Connection conn;
    private static final String SQL_SELECT = "select*from product";
    private static final String SQL_INSERT = "insert into product values(?,?,?)";
    private static final String SQL_SAVE = "update product set name = ?,author = ?,price =? "+"where id = ?";



    public int insert(Product product) throws SQLException {
        if(product.getName()==null){
            return 0;
        }
        PreparedStatement preparedStatement = null;
        int result = 0;
        preparedStatement = connection.prepareStatement(SQL_INSERT );
        preparedStatement.setString(1,product.getName());
        preparedStatement.setDouble(2,product.getPrice());
        preparedStatement.setString(3,product.getAuthor());
        result = preparedStatement.executeUpdate();
        return result;
    }


    public int save(Product product) throws SQLException {
        if(product.getName()==null){
            return 0;
        }
        PreparedStatement preparedStatement = null;
        int result = 0;
        preparedStatement = connection.prepareStatement(SQL_SAVE);
        preparedStatement.setString(1,product.getName());
        preparedStatement.setString(2,product.getAuthor());
        preparedStatement.setDouble(3,product.getPrice());
        preparedStatement.setInt(4,product.getId());
        result = preparedStatement.executeUpdate();
        return result;
    }



    public List<Product> getAll() throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> product = new ArrayList<>();
        preparedStatement = connection.prepareStatement(SQL_SELECT);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");
            String author = resultSet.getString("author");
            System.out.println("id: " + id +"name:"+name+"price"+price+"author:"+author);
        }
        return product;
    }

}
