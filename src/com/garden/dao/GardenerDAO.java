package com.garden.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.garden.bean.Gardener;
import com.garden.util.DBUtil;


public class GardenerDAO {

    public Gardener findGardener(String id) throws Exception {
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement ps =connection.prepareStatement("SELECT * FROM GARDENER_TBL WHERE GARDENER_ID=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Gardener g = new Gardener();
            g.setGardenerID(rs.getString(1));
            g.setFullName(rs.getString(2));
            g.setHouseOrApartmentNo(rs.getString(3));
            g.setStreetName(rs.getString(4));
            g.setMobile(rs.getString(5));
            g.setEmail(rs.getString(6));
            g.setPreferredCategory(rs.getString(7));
            g.setStatus(rs.getString(8));
            return g;
        }
        return null;
        
    }

    public boolean insertGardener(Gardener g) throws Exception {
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement ps = connection.prepareStatement("INSERT INTO GARDENER_TBL VALUES(?,?,?,?,?,?,?,?)");
        ps.setString(1, g.getGardenerID());
        ps.setString(2, g.getFullName());
        ps.setString(3, g.getHouseOrApartmentNo());
        ps.setString(4, g.getStreetName());
        ps.setString(5, g.getMobile());
        ps.setString(6, g.getEmail());
        ps.setString(7, g.getPreferredCategory());
        ps.setString(8, g.getStatus());
        return ps.executeUpdate() > 0;
    }

    public boolean deleteGardener(String id) throws Exception {
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement ps =
            connection.prepareStatement("DELETE FROM GARDENER_TBL WHERE GARDENER_ID=?");
        ps.setString(1, id);
        return ps.executeUpdate() > 0;
    }
}
