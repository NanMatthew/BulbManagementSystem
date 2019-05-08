package com.sicnu.bulb.entity.msg;

/**
 * Created by HY
 * 2019/5/8 18:59
 */
@SuppressWarnings("unused")
public class LoginMsg extends Msg {

    /**
     * 用户类型
     */
    private int userType;

    public LoginMsg(int userType) {
        setResultCode(ResultCode.RESULT_CODE_CORRECT);
        switch (userType) {
            case 1://系统管理员
                setInfo("系统管理员");
                break;
            case 2://财务管理员
                setInfo("财务管理员");
                break;
            case 3://仓库管理员
                setInfo("仓库管理员");
                break;
        }
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
