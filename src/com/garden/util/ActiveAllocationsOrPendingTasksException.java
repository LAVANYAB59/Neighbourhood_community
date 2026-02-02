package com.garden.util;

public class ActiveAllocationsOrPendingTasksException extends Exception {
    public String toString() {
        return "Cannot remove gardener. Active allocations or pending tasks exist.";
    }
}
