package com.garden.app;

import com.garden.bean.Gardener;
import com.garden.service.GardenService;
import com.garden.util.PlotAllocationConflictException;
import com.garden.util.ValidationException;

public class GardenMain { 
       private static GardenService service = new GardenService(); 
       public static void main(String[] args) { 
       java.util.Scanner sc = new java.util.Scanner(System.in); 
       System.out.println("--- Community Garden Management Console ---"); 
       try { 
          Gardener g = new Gardener(); 
          g.setGardenerID("GD1201"); 
          g.setFullName("Rahul Mehta"); 
          g.setHouseOrApartmentNo("Flat 2B"); 
          g.setStreetName("Green Residency Road"); 
          g.setMobile("9876500001"); 
          g.setEmail("rahul.mehta@example.com"); 
          g.setPreferredCategory("VEGETABLES"); 
          g.setStatus("ACTIVE"); 
          boolean ok = service.registerNewGardener(g); 
          System.out.println(ok ? "GARDENER REGISTERED" : 
               "GARDENER REGISTRATION FAILED"); 
     }
       catch (ValidationException e) { 
               System.out.println("Validation Error: " + 
                                 e.toString()); 
    } 
       catch (Exception e) { 
              System.out.println("System Error: " + 
                         e.getMessage()); 
         } 
 
           try { 
           java.sql.Date start = new 
           java.sql.Date(System.currentTimeMillis()); 
           java.sql.Date end = new 
           java.sql.Date(System.currentTimeMillis() + 90L*24*60*60*1000); 
           boolean ok = service.allocatePlotToGardener( 
                    "GD1201", 
                    "P16", 
                    "Summer 2025", 
                     start, 
                     end 
           ); 
          System.out.println(ok ? "PLOT ALLOCATED" : "PLOT ALLOCATION FAILED"); 
        }
           catch (PlotAllocationConflictException e) { 
           System.out.println("Allocation Conflict: " + 
           e.toString()); 
        }
           catch (ValidationException e) { 
           System.out.println("Validation Error: " + 
           e.toString()); 
      }
           catch (Exception e) { 
           System.out.println("System Error: " + 
           e.getMessage()); 
      } 
      sc.close(); 
    } 
    }