package com.sicnu.bulb.entity.msg;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by HY
 * 2019/4/3 19:31
 * <p>
 * 返回的消息 基类
 */
@SuppressWarnings("unused")
public class Msg {

    /**
     * 返回码
     */
    private int resultCode;

    /**
     * 备注信息
     */
    private String info;

    /**
     * 空构造函数
     */
    public Msg() {
    }

    /**
     * 正确的消息
     *
     * @param info 备注信息
     */
    public Msg(String info) {
        this.resultCode = ResultCode.RESULT_CODE_CORRECT;
        this.info = info;
    }

    /**
     * 通过resultCode自动补全info信息
     *
     * @param resultCode resultCode
     */
    public Msg(int resultCode) {
        this.resultCode = resultCode;
        this.info = getResultCodeInfo(resultCode);
    }

    /**
     * 自定义消息
     *
     * @param resultCode resultCode
     * @param info       info
     */
    public Msg(int resultCode, String info) {
        this.resultCode = resultCode;
        this.info = info;
    }

    /**
     * 生成错误的Msg对象
     *
     * @param info info
     * @return Msg
     */
    public static Msg errorMsg(String info) {
        return new Msg(ResultCode.RESULT_CODE_ERROR, info);
    }

    /**
     * 消息是否正确
     *
     * @return 消息是否正确
     */
    @JsonIgnore  //屏蔽该方法 转换成json时不会显示
    public boolean isCorrectMsg() {
        return this.resultCode == ResultCode.RESULT_CODE_CORRECT;
    }

    /**
     * 根据返回码设置相应的信息
     *
     * @param resultCode resultCode
     * @return info
     */
    @JsonIgnore
    private String getResultCodeInfo(int resultCode) {
        String info = null;
        switch (resultCode) {
            case ResultCode.RESULT_CODE_CORRECT:
                info = "正确";
                break;
            case ResultCode.RESULT_CODE_ERROR:
                info = "错误";
                break;
            case ResultCode.RESULT_CODE_NOT_KNOWN_ERROR:
                info = "预期之外的错误";
                break;
            case ResultCode.RESULT_CODE_USER_NOT_EXIST:
                info = "用户名不存在";
                break;
            case ResultCode.RESULT_CODE_ERROR_PASSWORD:
                info = "密码错误";
                break;
            case ResultCode.RESULT_CODE_NEED_LOGIN:
                info = "未登录就请求其他页面";
                break;
            case ResultCode.RESULT_CODE_NO_PERMISSION:
                info = "未授权";
                break;
            case ResultCode.RESULT_CODE_NOT_FOUND:
                info = "Not Found";
                break;
            case ResultCode.RESULT_CODE_INTERNAL_SERVER_ERROR:
                info = "Internal Server Error";
                break;
        }
        return info;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
