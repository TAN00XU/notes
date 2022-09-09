package com.tan00xu.views;

import com.tan00xu.controller.ViewerOperatorController;
import com.tan00xu.model.LoginInfo;
import com.tan00xu.model.Viewer;
import com.tan00xu.utils.CmdOutputInformationUtils;
import com.tan00xu.utils.InputUtils;

/**
 * 登录视图类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class LoginView {

    /**
     * 登录
     *
     * @return boolean
     */
    public static boolean login() {
        long tel = (long) InputUtils.getNumber("long","请输入手机号：");
        String password = InputUtils.getString("请输入密码：");
        Viewer viewerByTelAndPassword = ViewerOperatorController.getViewerByTelAndPassword(tel, password);
        if(viewerByTelAndPassword!=null) {
            CmdOutputInformationUtils.debug("登录成功！");
            LoginInfo.setLoginInfo(viewerByTelAndPassword);
            return true;
        }
        CmdOutputInformationUtils.error("登录失败，账号或密码错误！");
        return false;
    }

    /**
     * 登录管理
     *
     * @return boolean
     */
    public static boolean loginAdmin() {
        String username = InputUtils.getString("请输入用户名：");
        String password = InputUtils.getString("请输入密码：");
        if ("admin".equals(username) && "666666".equals(password)) {
            CmdOutputInformationUtils.debug("管理员登录成功！");
            return true;
        }
        CmdOutputInformationUtils.error("登录失败，账号或密码错误！");
        return false;
    }
}
