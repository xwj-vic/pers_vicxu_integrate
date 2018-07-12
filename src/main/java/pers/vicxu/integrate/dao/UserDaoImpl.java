package pers.vicxu.integrate.dao;

import pers.vicxu.integrate.pojo.User;
import pers.vicxu.integrate.util.DbUtil;
import pers.vicxu.integrate.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Create by UserDaoImpl on 7/12/2018
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?)";
        Connection conn = DbUtil.getConnection();
        PreparedStatement statement = null;
        int i = 0;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUname());
            statement.setInt(3, user.getAge());
            statement.setBoolean(4, user.isSex());
            statement.setString(5, DateUtil.format.format(user.getBirth()));
            i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, statement, null);
        }
        return i;
    }
}
