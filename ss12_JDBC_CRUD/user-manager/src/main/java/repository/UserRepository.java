package repository;

import controller.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users(name, email, country) VALUE(?,?,?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name =?, email = ?, country = ? WHERE id = ?;";
    private static final String SELECT_USER_BY_COUNTRY = "SELECT * FROM users WHERE country = ?;";
    private static final String SORT_BY_NAME = "SELECT * FROM users ORDER BY name;";
    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USERS);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    DBConnection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userList;
    }

    @Override
    public User findById(int id) {
//        List<User> userList = findAll();
//        for (User user : userList) {
//            if (id == user.getId()) {
//                return user;
//            }
//        }
//        return null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return user;
    }




    @Override
    public void deleteUser(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_USERS_SQL);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void updateUser(int id, User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_USERS_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void insertUser(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_USERS_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public User searchByCountry(String country) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
                statement.setString(1, country);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    user = new User(id, name, email, country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return user;
    }

    @Override
    public List<User> sortByName() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SORT_BY_NAME);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    DBConnection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userList;
    }
}
