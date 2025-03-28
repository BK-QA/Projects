package com.Dao;

import com.entity.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class todoDao {

    public Connection con;

    public todoDao(Connection con) {
        super();
        this.con = con;
    }

    public boolean add_todo(String name, String todo, String status) {
        boolean flag = false;
        try {
            String query = "INSERT INTO entities(name, todo,status) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, todo);
            preparedStatement.setString(3, status);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("Data is inserted Successfully");
                flag = true;
            } else {
                System.out.println("Error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<entities> getTodoDtls() {
        List<entities> list = new ArrayList<>();
        entities t = null;

        try {
            String query = "SELECT * FROM entities";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                t = new entities();
                t.setId(rs.getInt(1));
                t.setName(rs.getString(2));
                t.setTodo(rs.getString(3));
                t.setStatus(rs.getString(4));

                list.add(t);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public entities getToDoById(int id) {
        entities t = null;

        try {
            String query = "SELECT * FROM entities WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                t = new entities();
                t.setId(resultSet.getInt(1));
                t.setName(resultSet.getString(2));
                t.setTodo(resultSet.getString(3));
                t.setStatus(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    public boolean updateTodo(entities entities) {
        boolean flag = false;

        try {
            String query = "UPDATE entities SET name=?, todo=?, status=? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, entities.getName());
            preparedStatement.setString(2, entities.getTodo());
            preparedStatement.setString(3, entities.getStatus());
            preparedStatement.setInt(4, entities.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteToDoById(int id) {
        boolean flag = false;

        try {
            String query = "DELETE FROM entities WHERE id=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
