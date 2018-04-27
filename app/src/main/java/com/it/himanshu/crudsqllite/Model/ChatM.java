package com.it.himanshu.crudsqllite.Model;

/**
 * Created by Himanshu on 02/02/2018.
 */

public class ChatM
{

    int id;
    String chat1;
    int flag1=0;

    public ChatM(int id, String chat1, int flag1) {
        this.id = id;
        this.chat1 = chat1;
        this.flag1 = flag1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChat1() {
        return chat1;
    }

    public void setChat1(String chat1) {
        this.chat1 = chat1;
    }

    public int getFlag1() {
        return flag1;
    }

    public void setFlag1(int flag1) {
        this.flag1 = flag1;
    }
}
