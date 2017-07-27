package dao;

import model.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 02.07.2017.
 */
public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DBUtil.getConnection();
    }

    public void addUser(User user){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO users(firstname, lastname, dob, email) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, new Date(user.getDob().getTime()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM users WHERE userid = ?");

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE users SET firstname = ?, lastname = ?, dob = ?, email = ? WHERE userid = ?");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setDate(3, new Date(user.getDob().getTime()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while(rs.next()){
                User user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setDob(rs.getDate("dob"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public User getUserById(int userId){
        User user = new User();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM users WHERE userid = ?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setDob(rs.getDate("dob"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
