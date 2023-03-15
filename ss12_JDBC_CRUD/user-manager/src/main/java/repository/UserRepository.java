package repository;

import controller.DBConnection;
import model.User;

import java.sql.*;
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
        List<User> userList = findAll();
        for (User user : userList) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        User user = null;
//        if (connection != null) {
//            try {
//                statement = connection.prepareStatement(SELECT_USER_BY_ID);
//                statement.setInt(1, id);
//                resultSet = statement.executeQuery();
//                while (resultSet.next()) {
//                    String name = resultSet.getString("name");
//                    String email = resultSet.getString("email");
//                    String country = resultSet.getString("country");
//                    user = new User(id, name, email, country);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    resultSet.close();
//                    statement.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                DBConnection.close();
//            }
//        }
//        return user;
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
    public List<User> searchByCountry(String country) {
        List<User> userList = findAll();
        List<User> userListByCountry = new ArrayList<>();
        for (User user : userList) {
            if (country.equals(user.getCountry())) {
                userListByCountry.add(user);
            }
        }
        return userListByCountry;
    }
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        User user = null;
//        if (connection != null) {
//            try {
//                statement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
//                statement.setString(1, country);
//                resultSet = statement.executeQuery();
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    String email = resultSet.getString("email");
//                    user = new User(id, name, email, country);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    resultSet.close();
//                    statement.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                DBConnection.close();
//            }
//        }
//        return user;
//    }

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

    @Override
    public List<User> findAllMethod() {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareCall("call findAll()");
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
    public void updateUserMethod(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("call updateUser(?, ?, ?, ?)");
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
    public void deleteUserMethod(int id) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall("call deleteUser(?)");
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
    public void updateUserTransaction() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        User user1 = new User(10, "Hung", "hunghon@gmail.com", "ThaiLan");
        User user2 = new User(11, "Nam", "NamHa@gmail.com", "Lao");
        Savepoint savepoint = null;
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement.setString(1, user1.getName());
                statement.setString(2, user1.getEmail());
                statement.setString(3, user1.getCountry());
                statement.executeUpdate();
                savepoint = connection.setSavepoint();
                statement = connection.prepareStatement(INSERT_USERS_SQL);
                statement.setString(1, user2.getName());
                statement.setString(2, user2.getEmail());
                statement.setString(3, user2.getCountry());
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement = connection.prepareStatement(INSERT_USERS_SQL);
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
}
