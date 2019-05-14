package com.sicnu.bulb.controller;

import com.google.gson.JsonSyntaxException;
import com.sicnu.bulb.entity.LoginLog;
import com.sicnu.bulb.entity.OperationLog;
import com.sicnu.bulb.entity.msg.LogMsg;
import com.sicnu.bulb.entity.msg.Msg;
import com.sicnu.bulb.util.FileUtil;
import com.sicnu.bulb.util.GsonUtil;
import org.springframework.web.bind.annotation.GetMapping;
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


    /**
     * 获取操作日志
     *
     * @return {@link Msg}
     */
    @GetMapping("/log/operationLogs")
    public Msg getOperationLogs() {
        return readOperationLogs();
    }

    /**
     * 获取登录日志
     *
     * @return {@link Msg}
     */
    @GetMapping("/log/loginLogs")
    public Msg getLoginLogs() {
        return readLoginLogs();
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
