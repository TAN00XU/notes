package com.tan00xu;

import com.tan00xu.controller.TicketOperatorController;
import com.tan00xu.utils.CmdOutputInformationUtils;
import com.tan00xu.utils.InputUtils;
import com.tan00xu.views.AdminViews;
import com.tan00xu.views.LoginView;
import com.tan00xu.views.RegisterView;
import com.tan00xu.views.TicketViews;

/**
 * 预订系统主类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class BookingSystem {
    public static void main(String[] args) {
        CmdOutputInformationUtils.info("欢迎进入演出大厅售票系统！");
        TicketOperatorController.init();
        boolean flag = true;
        while (flag) {
            int i = InputUtils.getInt("请选择操作：\n\t1.注册\n\t2.登录\n\t3.游客\n\t4.退出系统\n\t其它选项都退出系统");
            switch (i) {
                //注册
                case 1:
                    RegisterView.register();
                    break;
                //登录
                case 2:
                    boolean flag1 = true;
                    while (flag1) {
                        i = InputUtils.getInt("请选择操作：\n\t1.用户登录\n\t2.管理员登录\n\t3.退出此界面\n\t其它选项都退出系统");
                        switch (i) {
                            //用户登录
                            case 1:
                                if (LoginView.login()) {
                                    i = InputUtils.getInt("请选择操作：\n\t1.查询票信息\n\t2.订票\n\t3.退出此界面\n\t其它选项都退出系统");
                                    switch (i) {
                                        case 1:
                                            boolean flagShowTicket = true;
                                            while (flagShowTicket) {
                                                i = InputUtils.getInt("请选择操作：\n\t1.查看所有票信息\n\t2.查询某张票是否被预订\n\t3.根据区域和排查询票\n\t4.根据区域查询票\n\t5.查询票根据价格\n\t6.退出此界面\n\t其它选项都退出系统");
                                                switch (i) {
                                                    case 1:
                                                        TicketViews.queryTicket();
                                                        break;
                                                    case 2:
                                                        TicketViews.queryTicketReserve();
                                                        break;
                                                    case 3:
                                                        TicketViews.queryTicketAreaAndRow();
                                                        break;
                                                    case 4:
                                                        TicketViews.queryTicketArea();
                                                        break;
                                                    case 5:
                                                        TicketViews.queryTicketByPrice();
                                                        break;
                                                    case 6:
                                                        CmdOutputInformationUtils.error("已退出此界面");
                                                        flagShowTicket = false;
                                                        break;
                                                    default:
                                                        CmdOutputInformationUtils.error("已退出系统");
                                                        flagShowTicket = false;
                                                        flag1 = false;
                                                        flag = false;
                                                }
                                            }
                                            break;
                                        case 2:
                                            TicketViews.bookingTicket();
                                            break;
                                        case 3:
                                            CmdOutputInformationUtils.error("已退出此界面");
                                            flag1 = false;
                                            break;
                                        default:
                                            CmdOutputInformationUtils.error("已退出系统");
                                            flag1 = false;
                                            flag = false;
                                    }
                                }
                                break;
                            //管理员登录
                            case 2:
                                if (LoginView.loginAdmin()) {
                                    boolean flagAdmin = true;
                                    while (flagAdmin) {
                                        i = InputUtils.getInt("请选择操作：\n\t1.锁票\n\t2.查看所有观众\n\t3.退出此界面\n\t其它选项都退出系统");
                                        switch (i) {
                                            case 1:
                                                TicketViews.systemBooking(0);
                                                break;
                                            case 2 :
                                                if(!AdminViews.queryListViewers()){
                                                    CmdOutputInformationUtils.error("出错");
                                                }
                                                break;
                                            case 3:
                                                CmdOutputInformationUtils.error("已退出此界面");
                                                flagAdmin = false;
                                                break;
                                            default:
                                                CmdOutputInformationUtils.error("已退出系统");
                                                flagAdmin = false;
                                                flag = false;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                CmdOutputInformationUtils.error("已退出此界面");
                                flag1 = false;
                                break;
                            default:
                                CmdOutputInformationUtils.error("已退出系统");
                                flag1 = false;
                                flag = false;
                        }
                    }
                    break;
                //游客进入
                case 3:
                    boolean flagVisitor = true;
                    while (flagVisitor) {
                        i = InputUtils.getInt("请选择操作：\n\t1.查看所有票信息\n\t2.查询某张票是否被预订\n\t3.根据区域和排查询票\n\t4.根据区域查询票\n\t5.查询票根据价格\n\t6.退出此界面\n\t其它选项都退出系统");
                        switch (i) {
                            case 1:
                                TicketViews.queryTicket();
                                break;
                            case 2:
                                TicketViews.queryTicketReserve();
                                break;
                            case 3:
                                TicketViews.queryTicketAreaAndRow();
                                break;
                            case 4:
                                TicketViews.queryTicketArea();
                                break;
                            case 5:
                                TicketViews.queryTicketByPrice();
                                break;
                            case 6:
                                CmdOutputInformationUtils.error("已退出此界面");
                                flagVisitor = false;
                                break;
                            default:
                                CmdOutputInformationUtils.error("已退出系统");
                                flagVisitor = false;
                                flag = false;
                        }
                    }
                    break;
                //退出系统
                case 4:
                    CmdOutputInformationUtils.error("已退出系统");
                    flag = false;
                    break;
                default:
                    CmdOutputInformationUtils.error("已退出系统");
                    flag = false;

            }

        }
    }
}
