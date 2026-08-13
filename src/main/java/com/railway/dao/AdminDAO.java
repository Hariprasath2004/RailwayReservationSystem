package com.railway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.railway.config.DBConnection;
import com.railway.model.Admin;

public class AdminDAO {

    public Admin getAdminByEmail(String email) {

        Admin admin = null;

        String sql = "SELECT * FROM admins WHERE email=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                admin = new Admin();

                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPasswordHash(rs.getString("password_hash"));

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return admin;

    }

}