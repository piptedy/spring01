package com.atguigu.spring;

import org.junit.Test;

public class TestNode {
    @Test
    public void test01(){
        MySingleWayList<String> mySingleWayList = new MySingleWayList<>();
        System.out.println(mySingleWayList.getSize());
        System.out.println(mySingleWayList.toString());
        mySingleWayList.add("钢铁侠");
        mySingleWayList.add("蜘蛛侠");
        System.out.println("---------------------------");
        System.out.println(mySingleWayList.getSize());
        System.out.println(mySingleWayList.toString());
    }
}
