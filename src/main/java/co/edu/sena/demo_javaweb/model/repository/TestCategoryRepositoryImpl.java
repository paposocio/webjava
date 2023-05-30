package co.edu.sena.demo_javaweb.model.repository;

import co.edu.sena.demo_javaweb.model.beans.Category;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<Category> repository = new CategoryRepositoryImpl();

        System.out.println("-------------saveObj Insert-------------");
        Category categoryInsert = new Category();
        categoryInsert.setCategoryName("Category 1");
        repository.saveObj(categoryInsert);

        categoryInsert.setCategoryName("Category 2");
        repository.saveObj(categoryInsert);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("-------------byIdObj-------------");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("-------------saveObj Update-------------");
        Category categoryUpdate = new Category();
        categoryUpdate.setCategoryId(2);
        categoryUpdate.setCategoryName("Updated Category");
        repository.saveObj(categoryUpdate);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("-------------deleteObj-------------");
        repository.deleteObj(2);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
    }
}
