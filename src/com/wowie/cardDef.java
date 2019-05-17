package com.wowie;

public class cardDef implements card {
    private int power;

    private String bTxt;
    private String name;

    public cardDef(String nm, int pw, String txt){
        name = nm;
        power = pw;

        bTxt = txt;
    }
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
        return -1;
    }

    public String getBattleTxt(){
        return bTxt;
    }
}
