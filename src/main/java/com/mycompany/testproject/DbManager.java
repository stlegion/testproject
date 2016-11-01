package com.mycompany.testproject;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class DbManager {

    @Autowired
    private DataSource dataSource;

    public void persistUser(User user) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            insertUserInfo(user, conn);
            conn.commit();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if(conn != null)
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    private void insertUserInfo(User user, Connection conn) throws SQLException, IOException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, surname, birthdate, file) VALUES (?, ?, ?, ?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getSurname());
        ps.setDate(3, new Date(user.getBirthdate().getTime()));
        try (DataInputStream din = new DataInputStream(new FileInputStream(user.getProfile()))) {
            byte[] bytes = new byte[(int) user.getProfile().length()];
            din.read(bytes);
            ps.setBytes(4, bytes);
        }
        ps.executeUpdate();
    }
}
