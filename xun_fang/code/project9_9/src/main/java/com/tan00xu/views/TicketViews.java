package com.tan00xu.views;

import com.tan00xu.controller.TicketOperatorController;
import com.tan00xu.model.LoginInfo;
import com.tan00xu.model.Ticket;
import com.tan00xu.model.Viewer;
import com.tan00xu.utils.CmdOutputInformationUtils;
import com.tan00xu.utils.InputUtils;

import java.util.ArrayList;

/**
 * 票视图类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class TicketViews {
    /**
     * 系统预订
     *
     * @return boolean
     */
    public static boolean systemBooking(long tel) {
        Ticket ticket = new Ticket();
        int i = InputUtils.getInt("请选择要封票的区域:\n\t1.东区\n\t2.南区\n\t3.西区\n\t4.北区");
        String area = i == 1 ? "东区" : i == 2 ? "南区" : i == 3 ? "西区" : i == 4 ? "北区" : null;
        if (area != null) {
            ticket.setArea(area);
            i = InputUtils.getInt("请选择排数:1-10");
            if (i <= 10 && i > 0) {
                ticket.setRow(i);
                i = InputUtils.getInt("请选择号数:1-20");
                if (i <= 20 && i > 0) {
                    ticket.setNumber(i);
                    Ticket ticket1 = TicketOperatorController.getTicketPrecise(ticket.getArea(), ticket.getRow(), ticket.getNumber()).get(0);
                    if (tel == 0) {
                        if (!ticket1.isReserve()) {
                            ticket.setReserve(true);
                            TicketOperatorController.updateTicket(ticket);
                            CmdOutputInformationUtils.info("封票成功");
                            return true;
                        } else {
                            CmdOutputInformationUtils.debug("此票已出售，不可锁定");
                        }
                    } else {
                        if (!ticket1.isReserve()) {
                            ticket.setReserve(true);
                            ticket.setTel(tel);
                            TicketOperatorController.updateTicket(ticket);
                            CmdOutputInformationUtils.info("购票成功");
                            return true;
                        } else {
                            CmdOutputInformationUtils.debug("此票已出售");
                        }
                    }

                } else {
                    CmdOutputInformationUtils.error("请输入正确的号数");
                }
            } else {
                CmdOutputInformationUtils.error("请输入正确的排数");
            }
        } else {
            CmdOutputInformationUtils.error("请选择正确的区域");
        }
        return false;
    }

    /**
     * 查询所有票 用户
     *
     * @return boolean
     */
    public static boolean queryTicket() {
        ArrayList<Ticket> tickets = TicketOperatorController.listTickets();
        return showListTickets(tickets);
//        CmdOutputInformationUtils.warn("区域\t\t排数\t\t号数\t\t价格\t\t是否被预定");
//        if (tickets != null) {
//            for (Ticket ticket : tickets) {
//                System.out.println(
//                        ticket.getArea() + "\t\t" +
//                                ticket.getRow() + "\t\t" +
//                                ticket.getNumber() + "\t\t" +
//                                ticket.getPrice() + "元\t\t" +
//                                (ticket.isReserve() ? "是" : "否")
//                );
//            }
//            return true;
//        }
//        return false;
    }

    /**
     * 预订票
     *
     * @return boolean
     */
    public static boolean bookingTicket() {
        Viewer loginInfo = LoginInfo.getLoginInfo();
        return systemBooking(loginInfo.getTel());
    }


    /**
     * 查询票，管理员模式
     *
     * @return boolean
     */
    public static boolean queryTicketAdmin() {
        CmdOutputInformationUtils.warn("区域\t\t排数\t\t号数\t\t价格\t\t是否被预定\t\t电话");
        ArrayList<Ticket> tickets = TicketOperatorController.listTickets();
        if (tickets != null) {
            for (Ticket ticket : tickets) {
                System.out.println(
                        ticket.getArea() + "\t\t" +
                                ticket.getRow() + "\t\t" +
                                ticket.getNumber() + "\t\t" +
                                ticket.getPrice() + "元\t\t" +
                                (ticket.isReserve() ? "是" : "否") + "\t\t" +
                                ticket.getTel()
                );
            }
            return true;
        }
        return false;
    }

    /**
     * 查询某张票是否被预订
     *
     * @return boolean
     */
    public static boolean queryTicketReserve() {
        String area;
        int row;
        int number;

        int i = InputUtils.getInt("请选择要查询的区域:\n\t1.东区\n\t2.南区\n\t3.西区\n\t4.北区");
        area = i == 1 ? "东区" : i == 2 ? "南区" : i == 3 ? "西区" : i == 4 ? "北区" : null;
        if (area != null) {
            row = InputUtils.getInt("请选择排数:1-10");
            if (row <= 10 && row > 0) {
                number = InputUtils.getInt("请选择号数:1-20");
                if (number <= 20 && number > 0) {
                    Ticket ticket1 = TicketOperatorController.getTicketPrecise(area, row, number).get(0);
                    if (!ticket1.isReserve()) {
                        CmdOutputInformationUtils.info(ticket1.getArea() + ticket1.getRow() + "排" + ticket1.getNumber() + "号未被购买");
                        return true;
                    } else {
                        CmdOutputInformationUtils.debug("此票已出售");
                    }
                } else {
                    CmdOutputInformationUtils.error("请输入正确的号数");
                }
            } else {
                CmdOutputInformationUtils.error("请输入正确的排数");
            }
        } else {
            CmdOutputInformationUtils.error("请选择正确的区域");
        }
        return false;
    }

    /**
     * 查询票根据区域和排
     *
     * @return boolean
     */
    public static boolean queryTicketAreaAndRow() {
        String area;
        int row;
        int i = InputUtils.getInt("请选择要查询的区域:\n\t1.东区\n\t2.南区\n\t3.西区\n\t4.北区");
        area = i == 1 ? "东区" : i == 2 ? "南区" : i == 3 ? "西区" : i == 4 ? "北区" : null;
        if (area != null) {
            row = InputUtils.getInt("请选择排数:1-10");
            if (row <= 10 && row > 0) {
                ArrayList<Ticket> ticketPrecise = TicketOperatorController.getTicketPrecise(area, row);
                return showListTickets(ticketPrecise);
            } else {
                CmdOutputInformationUtils.error("请输入正确的排数");
            }
        } else {
            CmdOutputInformationUtils.error("请选择正确的区域");
        }
        return false;
    }


    /**
     * 查询票根据区域
     *
     * @return boolean
     */
    public static boolean queryTicketArea() {
        int i = InputUtils.getInt("请选择要查询的区域:\n\t1.东区\n\t2.南区\n\t3.西区\n\t4.北区");
        String area = i == 1 ? "东区" : i == 2 ? "南区" : i == 3 ? "西区" : i == 4 ? "北区" : null;
        if (area != null) {
            ArrayList<Ticket> ticketPrecise = TicketOperatorController.getTicketPrecise(area);
            return showListTickets(ticketPrecise);

        } else {
            CmdOutputInformationUtils.error("请选择正确的区域");
        }
        return false;
    }

    /**
     * 遍历显示票
     *
     * @param tickets 票
     * @return boolean
     */
    public static boolean showListTickets(ArrayList<Ticket> tickets) {
        if (tickets != null) {
//            CmdOutputInformationUtils.warn("区域\t\t排数\t\t号数\t\t价格\t\t是否被预定");
//            for (Ticket ticket : tickets) {
//
//                System.out.println(
//                        ticket.getArea() + "\t\t" +
//                        ticket.getRow() + "\t\t" +
//                        ticket.getNumber() + "\t\t" +
//                        ticket.getPrice() + "元\t\t" +
//                        (ticket.isReserve() ? "是" : "否")
//                );
//            }
            for (int i = 0; i < tickets.size(); i++) {
                if (i % 10 == 0) {
                    CmdOutputInformationUtils.warn("区域\t\t排数\t\t号数\t\t价格\t\t是否被预定");
                }
                System.out.println(
                        tickets.get(i).getArea() + "\t\t" +
                                tickets.get(i).getRow() + "\t\t" +
                                tickets.get(i).getNumber() + "\t\t" +
                                tickets.get(i).getPrice() + "元\t\t" +
                                (tickets.get(i).isReserve() ? "是" : "否")
                );
            }
            return true;
        }
        return false;
    }


    /**
     * 查询票根据价格
     *
     * @return boolean
     */
    public static boolean queryTicketByPrice() {
        int i = InputUtils.getInt("请选择要查询的价格:\n\t1. 1680元\n\t2. 1280元\n\t3. 980元\n\t4. 680元");
        if (i >= 0 && i <= 4) {
            int price = i == 1 ? 1680 : i == 2 ? 1280 : i == 3 ? 980 : i == 4 ? 680 : 0;
            ArrayList<Ticket> ticketByPrice = TicketOperatorController.getTicketByPrice(TicketOperatorController.listTickets(), price);
            System.out.println(ticketByPrice);
            return showListTickets(ticketByPrice);
        }
        CmdOutputInformationUtils.error("请选择正确的价格");
        return false;
    }
}
