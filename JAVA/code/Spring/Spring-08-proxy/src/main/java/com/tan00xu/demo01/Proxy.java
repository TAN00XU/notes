package com.tan00xu.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy(){

    }
    public Proxy(Host host) {
        this.host = host;
    }
    @Override
    public void rent(){
        host.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void heTong(){
        System.out.println("中介签合同");
    }
    public void fare(){
        System.out.println("中介收中介费");
    }
}

