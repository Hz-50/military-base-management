package com.militarybase.model;

public class LogEntry {
    private String log;
    private String logDateandTime;
    private String logCategory;

    public LogEntry(String log, String logCategory, String logDateandTime) {
        this.log = log;
        this.logCategory = logCategory;
        this.logDateandTime = logDateandTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLogCategory() {
        return logCategory;
    }

    public void setLogCategory(String logCategory) {
        this.logCategory = logCategory;
    }

    public String getLogDateandTime() {
        return logDateandTime;
    }

    public void setLogDateandTime(String logDateandTime) {
        this.logDateandTime = logDateandTime;
    }
}
