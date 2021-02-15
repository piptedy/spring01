package com.atguigu.spring;

import java.util.Arrays;

public class MySingleWayList<T> {
    Node head;
    int count;
    class Node{
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 添加一个节点
     * @param t
     */
   public void add(T t){
       Node newNode = new Node(t,null);
        if(head==null){
            head=newNode;
            count++;
            return;
        }
        Node node = head;
        while(node.next!=null){
            node = node.next;
        }

        node.next = newNode;
        count++;

   }

    /**
     *
     * @return 总节点数
     */
   public int getSize(){
       return count;
   }

    /**
     * 遍历所有节点的数据
     * @return
     */
    @Override
    public String toString() {
       //1.new一个数组来装载所有的data,便于操作
        Object[] o = new Object[count];
        //2.遍历，取出所有的节点的data
        Node node = head;
        for (int i = 0; i <count ; i++) {

            o[i] = node.data;
            node = node.next;
        }
        //3.打印数组
        return Arrays.toString(o);
    }


}
