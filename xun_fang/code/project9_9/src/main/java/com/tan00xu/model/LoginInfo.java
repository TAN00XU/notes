package com.tan00xu.model;

import com.tan00xu.utils.ReadWriteUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录信息类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */

public class LoginInfo {

    public static Viewer getLoginInfo() {
        return (Viewer) ReadWriteUtils.readObject("loginInfo.txt");
    }

    public static void setLoginInfo(Viewer loginView) {
        ReadWriteUtils.writeObject(loginView,"loginInfo.txt");
    }


    public static void main(String[] args) {
        System.out.println(getLoginInfo());
    }
}
