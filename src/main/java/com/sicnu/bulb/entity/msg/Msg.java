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
     * 消息是否正确
     *
     * @return 消息是否正确
     */
    @JsonIgnore  //屏蔽该方法 转换成json时不会显示
    public boolean isCorrectMsg() {
        return this.resultCode == ResultCode.RESULT_CODE_CORRECT;
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
