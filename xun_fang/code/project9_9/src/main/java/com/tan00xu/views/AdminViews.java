package com.tan00xu.views;

import com.tan00xu.controller.ViewerOperatorController;
import com.tan00xu.model.Viewer;

import java.util.ArrayList;

/**
 * 管理视图类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class AdminViews {
    /**
     * 查询观众列表
     *
     * @return boolean
     */
    public static boolean queryListViewers(){
        ArrayList<Viewer> viewers = ViewerOperatorController.listViewer();
        if (viewers != null) {
            viewers.forEach(System.out :: println);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        queryListViewers();
    }
}
