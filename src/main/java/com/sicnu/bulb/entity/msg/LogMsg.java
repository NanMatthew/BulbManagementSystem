package com.sicnu.bulb.entity.msg;

import java.util.List;

/**
 * Created by HY
 * 2019/5/14 14:00
 */
@SuppressWarnings("unused")
public class LogMsg<T> extends Msg {

    private List<T> logs;

    public LogMsg(List<T> logs) {
        super("日志列表");
        this.logs = logs;
    }

    public List<T> getLogs() {
        return logs;
    }

    public void setLogs(List<T> logs) {
        this.logs = logs;
    }
}
