package com.garden.util;

public class PlotAllocationConflictException extends Exception {
    public String toString() {
        return "Plot already allocated for this date range.";
    }
}
