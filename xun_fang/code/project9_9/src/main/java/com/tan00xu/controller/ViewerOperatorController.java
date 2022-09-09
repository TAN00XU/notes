package com.tan00xu.controller;

import com.tan00xu.model.Viewer;
import com.tan00xu.utils.CmdOutputInformationUtils;
import com.tan00xu.utils.ReadWriteUtils;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * 观众操作控制器类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class ViewerOperatorController {
    /**
     * 正则表达式手机号
     */
    public static final String REGEX_MOBILE = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
    /**
     * 正则表达式性别
     */
    public static final String REGEX_GENDER = "^(男|女){1}$";
    /**
     * 获取观众列表
     *
     * @return {@link ArrayList}<{@link Viewer}>
     */
    public static ArrayList<Viewer> listViewer() {
        return (ArrayList<Viewer>) ReadWriteUtils.readObject("Viewers.txt");
    }

    /**
     * 添加观众
     *
     * @param viewer 观众
     * @return boolean
     */
    public static boolean addViewer(Viewer viewer){
        if(!Pattern.matches(REGEX_GENDER,viewer.getGender())){
            CmdOutputInformationUtils.error("性别格式不正确！");
            return false;
        }
        if(!Pattern.matches(REGEX_MOBILE,String.valueOf(viewer.getTel()))){
            CmdOutputInformationUtils.error("手机号不正确，请重新输入！");
            return false;
        }
        ArrayList<Viewer> viewers = listViewer();

        if(viewers!=null) {
            for (Viewer thisViewers : viewers) {
                if (thisViewers.getTel()==(viewer.getTel())) {
                    return false;
                }
            }
        }else {
            viewers = new ArrayList<>();
        }
        viewers.add(viewer);
        ReadWriteUtils.writeObject(viewers, "viewers.txt");
        return true;

    }

    public static Viewer getViewerByTelAndPassword(long tell,String password){
        ArrayList<Viewer> viewers = listViewer();
        if(viewers!=null) {
            for (Viewer thisViewers : viewers) {
                if (thisViewers.getTel()==tell&&thisViewers.getPassword().equals(password)) {
                    return thisViewers;
                }
            }
        }
        return null;
    }

    /**
     * 查询观众通过电话
     *
     * @param tel 电话
     * @return {@link Viewer}
     */
    public static Viewer getViewerByTel(long tel){
        ArrayList<Viewer> viewers = listViewer();
        if (viewers != null) {
            for (Viewer thisViewers : viewers) {
                if (thisViewers.getTel() == tel){
                    return thisViewers;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(listViewer());
    }

}
