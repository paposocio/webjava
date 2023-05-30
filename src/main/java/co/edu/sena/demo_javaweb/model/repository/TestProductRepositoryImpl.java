package co.edu.sena.demo_javaweb.model.repository;

import co.edu.sena.demo_javaweb.model.beans.Product;
import java.sql.*;

public class TestProductRepositoryImpl {

    public static void main(String[] args) throws SQLException {
        Repository<Product> repository = new ProductRepositoryImpl();

        System.out.println("-------------saveObj Insert-------------");
        Product productInsert = new Product();
        productInsert.setProductName("Product A");
        productInsert.setProductValue(100);
        productInsert.setCategoryId(1);
        repository.saveObj(productInsert);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("-------------byIdObj-------------");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("-------------saveObj Update-------------");
        Product productUpdate = new Product();
        productUpdate.setProductId(1);
        productUpdate.setProductName("Updated Product A");
        productUpdate.setProductValue(150);
        productUpdate.setCategoryId(2);
        repository.saveObj(productUpdate);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("-------------deleteObj-------------");
        repository.deleteObj(1);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
    }
}
