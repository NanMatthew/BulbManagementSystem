package com.sicnu.bulb.entity.msg;

import java.util.List;

/**
 * Created by HY
 * 2019/5/14 14:00
 */
@SuppressWarnings("unused")
public class LogMsg<T> extends Msg {

    private List<T> logs;

    //当前页数
    private int currentPage;

    //总共页数
    private int totalPages;

    public LogMsg(List<T> logs) {
        super("日志列表");
        this.logs = logs;
    }

    public LogMsg(List<T> logs, int currentPage, int totalPages) {
        super("日志列表(分页)");
        this.logs = logs;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public List<T> getLogs() {
        return logs;
    }

    public void setLogs(List<T> logs) {
        this.logs = logs;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
