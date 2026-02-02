package com.garden.service;

import java.sql.Connection;
import java.sql.Date;

import com.garden.bean.Gardener;
import com.garden.bean.PlotTaskRow;
import com.garden.dao.GardenerDAO;
import com.garden.dao.PlotTaskDAO;
import com.garden.util.ActiveAllocationsOrPendingTasksException;
import com.garden.util.DBUtil;
import com.garden.util.PlotAllocationConflictException;
import com.garden.util.ValidationException;

public class GardenService {

    GardenerDAO gardenerDAO = new GardenerDAO();
    PlotTaskDAO plotDAO = new PlotTaskDAO();

    public boolean registerNewGardener(Gardener g)
        throws ValidationException, Exception {
    	
    	

        if (g.getGardenerID()==null || g.getFullName()==null)
            throw new ValidationException();

        if (gardenerDAO.findGardener(g.getGardenerID()) != null)
            throw new ValidationException();

        g.setStatus("ACTIVE");
        
        return gardenerDAO.insertGardener(g);
    }

    public boolean allocatePlotToGardener(String gardenerID, String plotNo, String season,Date start, Date end)throws Exception, PlotAllocationConflictException {
    	    if (plotDAO.findOverlappingAllocation(plotNo, start, end))
    	        throw new PlotAllocationConflictException();
    	    Connection connection = DBUtil.getDBConnection();
    	    connection.setAutoCommit(false);
    	    try {
    	        PlotTaskRow r = new PlotTaskRow();
    	        r.setRowID(plotDAO.generateRowID());
    	        r.setGardenerID(gardenerID);
    	        r.setServiceType("PLOT_ALLOCATION");
    	        r.setPlotNo(plotNo);
    	        r.setSeasonName(season);
    	        r.setAllocationStartDate(start);
    	        r.setAllocationEndDate(end);

    	        plotDAO.insertPlotTaskRow(connection, r);
    	        connection.commit();
    	        return true;
    	    } catch(Exception e) {
    	        connection.rollback();
    	        throw e;
    	    } finally {
    	        connection.close();
    	    }
    	}
    	public boolean removeGardener(String gardenerID, Date refDate)throws Exception, ActiveAllocationsOrPendingTasksException {
    	    if (plotDAO.hasActiveAllocations(gardenerID, refDate) || plotDAO.hasPendingTasks(gardenerID))throw new ActiveAllocationsOrPendingTasksException();
    	    return gardenerDAO.deleteGardener(gardenerID);
    	}
}