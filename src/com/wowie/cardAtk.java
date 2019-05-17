package com.wowie;

public class cardAtk implements card {
    private int power;

    private String bTxt;
    private String name;

    public cardAtk(String nm, int pw, String txt){
        name = nm;
        power = pw;
        bTxt = txt;


    }

    @Override
    public String toString() {
        return this.getName();
    }

    public int getStr() {
        return power;
    }
    public String getName(){
        return name;
    }


    public int getTyp(){
        return 1;
    }

    public String getBattleTxt(){
        return bTxt;
    }
}

