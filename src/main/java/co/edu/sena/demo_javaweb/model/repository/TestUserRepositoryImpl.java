package co.edu.sena.demo_javaweb.model.repository;

import co.edu.sena.demo_javaweb.model.beans.User;
import java.sql.*;

public class TestUserRepositoryImpl
{
    public static void main(String [] args) throws SQLException
    {
        Repository<User> repository = new UserRepositoryImpl();
        System.out.println("-------------saveObj Insert-------------");
        User userInsert = new User();
        userInsert.setUser_firstname("cHarles");
        userInsert.setUser_lastname("ocoro");
        userInsert.setUser_email("messi@sapo.com");
        userInsert.setUser_password("sap0321");
        repository.saveObj(userInsert);
        userInsert.setUser_firstname("juAN");
        userInsert.setUser_lastname("castillo");
        userInsert.setUser_email("cr7@piola.com");
        userInsert.setUser_password("qwerty");
        repository.saveObj(userInsert);

        System.out.println("-------------listAllObj-------------");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("-------------byIdObj-------------");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("-------------savedbj-------------");
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("jorge");
        userUpdate.setUser_lastname("palacios");
        userUpdate.setUser_email(" jorge@example.com");
        userUpdate.setUser_password("12345asdfg");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();
// update
        System.out.println("-------------delete0bj-------------");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System. out::println);
    }
}
