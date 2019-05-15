package com.sicnu.bulb.controller;

import com.google.gson.JsonSyntaxException;
import com.sicnu.bulb.entity.table.LoginLog;
import com.sicnu.bulb.entity.table.OperationLog;
import com.sicnu.bulb.entity.msg.LogMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.repository.LoginLogRepository;
import com.sicnu.bulb.repository.OperationLogRepository;
import com.sicnu.bulb.util.FileUtil;
import com.sicnu.bulb.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HY
 * 2019/5/14 11:10
 * <p>
 * 操作日志，登录日志相关
 */
@RestController
public class LogController {

    /**
     * 文件路径
     * <p>
     * 要与{@code log4j2.yml}中的{@code log.path}一致
     */
    private static final String FILE_PATH = "/logs/bulb/";

    /**
     * 操作日志
     */
    private static final String OPERATION_LOG = FILE_PATH + "operation.log";

    /**
     * 登录日志
     */
    private static final String LOGIN_LOG = FILE_PATH + "login.log";


    private final LoginLogRepository loginLogRepository;
    private final OperationLogRepository operationLogRepository;

    @Autowired
    public LogController(LoginLogRepository loginLogRepository, OperationLogRepository operationLogRepository) {
        this.loginLogRepository = loginLogRepository;
        this.operationLogRepository = operationLogRepository;
    }

    /**
     * 获取操作日志
     *
     * @return {@link Msg}
     */
    @com.sicnu.bulb.selflog.OperationLog(description = "获取操作日志")
    @GetMapping("/log/operationLogs")
    public Msg getOperationLogs() {
        return new LogMsg<>(operationLogRepository.findAll());
    }

    /**
     * 获取操作日志(分页)
     *
     * @return {@link Msg}
     */
    @com.sicnu.bulb.selflog.OperationLog(description = "获取登录日志(分页)")
    @GetMapping("/log/operationLogsPage")
    public Msg getOperationLogsPage(@RequestParam("currentPage") int currentPage,
                                    @RequestParam("prePageNum") int prePageNum) {

        return getMsg(currentPage, prePageNum, OPERATION_LOG);
    }

    /**
     * 获取登录日志
     *
     * @return {@link Msg}
     */
    @com.sicnu.bulb.selflog.OperationLog(description = "获取登录日志")
    @GetMapping("/log/loginLogs")
    public Msg getLoginLogs() {
        return new LogMsg<>(loginLogRepository.findAll());
    }

    /**
     * 获取登录日志(分页)
     *
     * @return {@link Msg}
     */
    @com.sicnu.bulb.selflog.OperationLog(description = "获取登录日志(分页)")
    @GetMapping("/log/loginLogsPage")
    public Msg getLoginLogsPage(@RequestParam("currentPage") int currentPage,
                                @RequestParam("prePageNum") int prePageNum) {

        return getMsg(currentPage, prePageNum, LOGIN_LOG);
    }


    private Msg getMsg(int currentPage, int prePageNum, String loginLog) {

        int totalNum;
        if (loginLog.equals(LOGIN_LOG)) {
            totalNum = loginLogRepository.queryTotalNum();
        } else {
            totalNum = operationLogRepository.queryTotalNum();
        }

        //总页数
        int totalPage = totalNum / prePageNum;
        if (totalPage * prePageNum < totalNum) {
            totalPage++;
        }

        //开始数
        int start = (currentPage - 1) * prePageNum;

        if (loginLog.equals(LOGIN_LOG)) {
            List<LoginLog> currentPageLogs = loginLogRepository.getCurrentPageLogs(start, prePageNum);
            return new LogMsg<>(currentPageLogs, currentPage, totalPage);
        } else {
            List<OperationLog> currentPageLogs = operationLogRepository.getCurrentPageLogs(start, prePageNum);
            return new LogMsg<>(currentPageLogs, currentPage, totalPage);
        }

    }


    /**
     * 读取操作日志并返回
     */
    @NotNull
    private Msg readOperationLogs() {
        List<OperationLog> operationLogs = new ArrayList<>();

        File file = new File(OPERATION_LOG);
        if (!file.exists()) {
            return new LogMsg<>(operationLogs);
        }
//        System.out.println("filePath:" + file.getAbsolutePath());
        try {
            BufferedReader bufferReader = FileUtil.getBufferReader(file);
            if (bufferReader != null) {
                String lineTxt;
                OperationLog log;
                while ((lineTxt = bufferReader.readLine()) != null) {
                    String[] split = lineTxt.split("&&");
                    try {
//                        System.out.println("json:" + split[1].trim());
                        //noinspection unchecked
                        log = GsonUtil.getInstance().fromJson(split[1].trim(), OperationLog.class);
                        operationLogs.add(log);
                    } catch (JsonSyntaxException | IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
                bufferReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
        return new LogMsg<>(operationLogs);
    }

    /**
     * 读取登录日志并返回
     */
    @NotNull
    private Msg readLoginLogs() {
        List<LoginLog> loginLogs = new ArrayList<>();

        File file = new File(LOGIN_LOG);
        if (!file.exists()) {
            return new LogMsg<>(loginLogs);
        }
//        System.out.println("filePath:" + file.getAbsolutePath());
        try {
            BufferedReader bufferReader = FileUtil.getBufferReader(file);
            if (bufferReader != null) {
                String lineTxt;
                LoginLog log;
                while ((lineTxt = bufferReader.readLine()) != null) {
                    try {
                        String[] split = lineTxt.split("&&");
//                        System.out.println("json:" + split[1].trim());
                        //noinspection unchecked
                        log = GsonUtil.getInstance().fromJson(split[1].trim(), LoginLog.class);
                        loginLogs.add(log);
                    } catch (JsonSyntaxException | IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
                bufferReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Msg.errorMsg(e.getMessage());
        }
        return new LogMsg<>(loginLogs);
    }
}
