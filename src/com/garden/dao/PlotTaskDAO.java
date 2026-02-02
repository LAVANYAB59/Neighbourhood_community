package com.garden.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.garden.bean.PlotTaskRow;
import com.garden.util.DBUtil;

public class PlotTaskDAO {

    public int generateRowID() throws Exception {
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement ps =connection.prepareStatement("SELECT NVL(MAX(ROW_ID),900000)+1 FROM PLOT_TASK_TBL");
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public boolean insertPlotTaskRow(Connection connection, PlotTaskRow r) throws Exception {

        String sql = "INSERT INTO PLOT_TASK_TBL VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, r.getRowID());
        ps.setString(2, r.getGardenerID());
        ps.setString(3, r.getServiceType());
        ps.setString(4, r.getPlotNo());
        ps.setString(5, r.getSeasonName());
        ps.setDate(6, r.getAllocationStartDate());
        ps.setDate(7, r.getAllocationEndDate());
        ps.setDate(8, r.getTaskDate());
        ps.setString(9, r.getTaskType());
        ps.setString(10, r.getTaskNotes());
        ps.setString(11, r.getTaskStatus());

        return ps.executeUpdate() > 0;
    }

    public boolean findOverlappingAllocation(
        String plotNo, Date startDate, Date endDate) throws Exception {

        Connection connection = DBUtil.getDBConnection();
        String sql = "SELECT ROW_ID FROM PLOT_TASK_TBL WHERE PLOT_NO=? " +"AND SERVICE_TYPE='PLOT_ALLOCATION' " + "AND NOT (ALLOCATION_END_DATE < ? OR ALLOCATION_START_DATE > ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, plotNo);
        ps.setDate(2, startDate);
        ps.setDate(3, endDate);

        ResultSet rs = ps.executeQuery();
        return rs.next();   
    }


    public boolean hasActiveAllocations(
        String gardenerID, Date refDate) throws Exception {

        Connection connection = DBUtil.getDBConnection();
        String sql = "SELECT ROW_ID FROM PLOT_TASK_TBL WHERE GARDENER_ID=? " +"AND SERVICE_TYPE='PLOT_ALLOCATION' AND ALLOCATION_END_DATE >= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, gardenerID);
        ps.setDate(2, refDate);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public boolean hasPendingTasks(String gardenerID) throws Exception {

        Connection connection = DBUtil.getDBConnection();
        String sql = "SELECT ROW_ID FROM PLOT_TASK_TBL WHERE GARDENER_ID=? " +"AND SERVICE_TYPE='MAINTENANCE_TASK' AND TASK_STATUS='PENDING'";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, gardenerID);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
}
