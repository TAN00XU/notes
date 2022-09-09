package com.tan00xu.views;

import com.tan00xu.controller.ViewerOperatorController;
import com.tan00xu.model.Viewer;
import com.tan00xu.utils.CmdOutputInformationUtils;
import com.tan00xu.utils.InputUtils;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 注册视图类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class RegisterView {
//    姓名、年龄、性别、手机号码、登录密码

    public static void register(){
        String name = InputUtils.getString("请输入姓名：");
        int age = InputUtils.getInt("请输入年龄：");
        String gender = InputUtils.getString("请输入性别：");
        long tel = (long) InputUtils.getNumber("long","请输入手机号：");
        String password = InputUtils.getString("请输入密码：");
        Viewer viewer = new Viewer(name, age, gender, tel, password,new ArrayList<>());
        if(ViewerOperatorController.addViewer(viewer)){
            CmdOutputInformationUtils.debug("注册成功！");
        }else {
            CmdOutputInformationUtils.error("注册失败或该手机号已注册");
        }
    }
}
