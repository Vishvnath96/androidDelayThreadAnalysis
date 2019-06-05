package com.mmt.travel.app.NFR.Latency.model;

import android.support.annotation.NonNull;

/**
 * Created by mmt6054 on 22/10/18.
 */

public class ThreadMetrics implements Comparable {
    String threadName;
    Integer noOfCallee;
    Long threadTotalTime;
    Long globalTotalTime;

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Integer getNoOfCallee() {
        return noOfCallee;
    }

    public void setNoOfCallee(Integer noOfCallee) {
        this.noOfCallee = noOfCallee;
    }

    public Long getThreadTotalTime() {
        return threadTotalTime;
    }

    public void setThreadTotalTime(Long threadTotalTime) {
        this.threadTotalTime = threadTotalTime;
    }

    public Long getGlobalTotalTime() {
        return globalTotalTime;
    }

    public void setGlobalTotalTime(Long globalTotalTime) {
        this.globalTotalTime = globalTotalTime;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return (int) (((ThreadMetrics)o).getThreadTotalTime() - this.getThreadTotalTime());
    }
}
