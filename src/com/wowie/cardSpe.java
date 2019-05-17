package com.wowie;

public class cardSpe implements card{
    private int power;
    private String bTxt;
    private String name;

    public cardSpe(String nm, String txt){
        name = nm;

        bTxt = txt;
    }

    public int getStr() {
        return 0;
    }
    public String getName(){
        return name;
    }

    public String toString() {
        return this.getName();
    }




    public int getTyp(){
        return 0;
    }

    public String getBattleTxt(){
        return bTxt;
    }
}
