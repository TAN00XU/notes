package com.tan00xu.controller;

import com.tan00xu.model.Ticket;
import com.tan00xu.utils.ReadWriteUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * 票操作控制器类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
public class TicketOperatorController {


    /**
     * 得到精确票信息
     *
     * @return {@link Ticket}
     */
    public static ArrayList<Ticket> getTicketPrecise(String area, int row, int number) {
        return getTicketByNumber(getTicketByRow(getTicketByArea(listTickets(), area), row), number);
    }
    public static ArrayList<Ticket> getTicketPrecise(String area, int row){
        return getTicketByRow(getTicketByArea(listTickets(),area),row);
    }
    public static ArrayList<Ticket> getTicketPrecise(String area){
        return getTicketByArea(listTickets(),area);
    }


    /**
     * 更新票信息
     *
     * @param ticket 票
     * @return boolean
     */
    public static boolean updateTicket(Ticket ticket){
        ArrayList<Ticket> tickets = listTickets();
        for (Ticket updateTicket : tickets) {
            if(updateTicket.getArea().equals(ticket.getArea())&&updateTicket.getRow()== ticket.getRow()&&updateTicket.getNumber()== ticket.getNumber()){
                updateTicket.setReserve(ticket.isReserve());
                updateTicket.setTel(ticket.getTel());
                return true;
            }
        }
        return false;
    }

    /**
     * 获取所有票信息
     *
     * @return {@link ArrayList}<{@link Ticket}>
     */
    public static ArrayList<Ticket> listTickets() {
        return (ArrayList<Ticket>) ReadWriteUtils.readObject("Tickets.txt");
    }

    /**
     * 初始化
     */
    public static void init() {
        File file = new File("src/main/resources/Tickets.txt");
        String[] area = {"东区", "南区", "西区", "北区"};
        ArrayList<Ticket> tickets = new ArrayList<>();
        if (!file.exists()||file.length()<=0) {
            //方位
            for (String s : area) {
                //排
                for (int j = 0; j < 10; j++) {
                    int price;
                    if (j < 3) {
                        price = 1680;
                    } else if (j < 6) {
                        price = 1280;
                    } else if (j < 9) {
                        price = 980;
                    } else {
                        price = 680;
                    }
                    //号
                    for (int k = 0; k < 20; k++) {
                        tickets.add(new Ticket(s, j + 1, k + 1, price, false, 0));
                    }
                }
            }
            ReadWriteUtils.writeObject(tickets, "Tickets.txt");
        }
    }



    /**
     * 按区查票
     *
     * @param area    区域
     * @param tickets 票集合
     * @return {@link ArrayList}<{@link Ticket}>
     */
    public static ArrayList<Ticket> getTicketByArea(ArrayList<Ticket> tickets,String area) {
        if (tickets != null) {
            ArrayList<Ticket> temp = new ArrayList<>();
            for (Ticket ticket : tickets) {
                if (ticket.getArea().equals(area)) {
                    temp.add(ticket);
                }
            }
            return temp;
        }
        return null;
    }

    /**
     * 按排查票
     *
     * @param tickets 票集合
     * @param row     排
     * @return {@link ArrayList}<{@link Ticket}>
     */
    public static ArrayList<Ticket> getTicketByRow(ArrayList<Ticket> tickets,int row) {
        if (tickets != null) {
            ArrayList<Ticket> temp = new ArrayList<>();
            for (Ticket ticket : tickets) {
                if (ticket.getRow()==row) {
                    temp.add(ticket);
                }
            }
            return temp;
        }
        return null;
    }

    /**
     * 按号查票
     *
     * @param tickets 票集合
     * @param number  号
     * @return {@link ArrayList}<{@link Ticket}>
     */
    public static ArrayList<Ticket> getTicketByNumber(ArrayList<Ticket> tickets,int number) {
        if (tickets != null) {
            ArrayList<Ticket> temp = new ArrayList<>();
            for (Ticket ticket : tickets) {
                if (ticket.getNumber()==number) {
                    temp.add(ticket);
                }
            }
            return temp;
        }
        return null;
    }

    /**
     * 按价格查票
     *
     * @param tickets 票集合
     * @param price   价格
     * @return {@link ArrayList}<{@link Ticket}>
     */
    public static ArrayList<Ticket> getTicketByPrice(ArrayList<Ticket> tickets,int price) {
        if (tickets != null) {
            ArrayList<Ticket> temp = new ArrayList<>();
            for (Ticket ticket : tickets) {
                if (ticket.getPrice()==price) {
                    temp.add(ticket);
                }
            }
            return temp;
        }
        return null;
    }

}
