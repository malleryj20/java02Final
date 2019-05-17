package com.wowie;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) {
        card[] normList = {
                new cardAtk("Quickdraw", 7, "Were it not for the blast mark, nobody would think you've done a thing. Unfortunately, that seems to include the robot.(-7)\n"),
                new cardAtk("Bull Rush", 9, "You're an actual moron for charging a robot. But it worked?(-9)\n"),
                new cardAtk("Circuit Breaker", 10, "I'm almost certain that's not what the phrase means, but the robot's hurt all the same.(-10)\n"),
                new cardAtk("High Voltage", 12, "It's rather shocking you'd do that.(-12)\n"),
                new cardDef("Kinetic Dynamo", 5, "Rock N' Roll with the punches. Still hurts though (+5)\n"),
                new cardDef("Emergency Shields", 10, "AAAAAAAAAA ENEMIES ARE SCARY(+10)\n"),
                new cardDef("Juggernaut", 14, "Nothing can stop you! Except damage.(+14)\n"),
                new cardSpe("Twinfork", "No, you can't eat food with arcs of electricity. Yes, that's from personal experience.(+5/-5)\n") //normal card pool
        };
        card[] rareList = {
                new cardSpe("Accelerate", "Time was really a suggestion, anyways. (+3 turns!)\n"),
                new cardAtk("HYPER BEAM",28,"Now that's just overkill.(-28)\n"),
                new cardDef("Bubble", 30, "Gonna cry? Gonna run to your safe-realitybendingforcefield?(30)\n") //rare / milestone card pool
        };
        int count = 0;
        ArrayList<card> deck = new ArrayList<card>();
        deck.add(normList[0]); //creates the starting deck
        deck.add(normList[0]);
        deck.add(normList[0]);
        deck.add(normList[1]);
        deck.add(normList[4]);
        deck.add(normList[4]);
        deck.add(normList[5]);
        String queue = "";
        int pHP = 40;
        int eHP;
        Boolean once = false;
        int choice;
        int Turns;
        card[] choices = {normList[0], normList[0]};
        Random f = new Random();
        JOptionPane.showMessageDialog(null, "The year is 23XX. The practically immortal dolpharian Vanzio dictates\n who lives and dies via a master control network of robots.\nYou are the last human, a now rare species\nthat was said to be the first to harness lightning.\nYou've gotten an extraordinarily lucky opportunity to enter\none of the few robot control nexuses, massive spiralling buldings that seem to\ngo on forever in all directions. You have but one goal: find the center.");
        while (pHP > 0){
            if (once){ //draft a new card into the deck by picking from a list.
                if (count%5==0){
                    choices[0] = rareList[f.nextInt(rareList.length)];
                    choices[1] = rareList[f.nextInt(rareList.length)];
                }
                else {
                    choices[0] = normList[f.nextInt(normList.length)];
                    choices[1] = normList[f.nextInt(normList.length)];
                }
                deck.add(choices[JOptionPane.showOptionDialog(null, "Pick a card to add to your deck!", "Draft",
                        -1, 1, null, choices, choices[0])]);

            }
            once = true;
            Collections.shuffle(deck);
            eHP = 40 + 3*count + 2^(count/2);
            pHP = 40;
            while (pHP > 0 && eHP > 0){
                Turns = 1;
                while (Turns >= 1){
                queue = "";
                choice = JOptionPane.showOptionDialog(null, "Pick a card! Turns Left: "+Turns, "Battle", //prompts player to pick a card
                        -1, 1, null, deck.subList(0,3).toArray(), deck.get(0));
                if (deck.get(choice).getTyp() == 1){
                    eHP = eHP - deck.get(choice).getStr();
                }
                if (deck.get(choice).getTyp() == -1){
                    pHP += deck.get(choice).getStr();
                }
                if (deck.get(choice).getTyp() == 0){
                    if (deck.get(choice).getName().equals("Accelerate")){
                        Turns += 3;
                    }
                    if (deck.get(choice).getName().equals("Twinfork")){ //specific functions for the two special cards
                        pHP += 5;
                        eHP -= 5;
                    }
                }
                queue += deck.get(choice).getBattleTxt();
                Turns--; //handles extra turns (accelerate)
                deck.add(deck.get(choice));
                deck.remove(choice);
                }
                if (eHP > 0){
                    queue += "The robot attacks!"+"\n";
                    pHP -= 6;
                }
                queue += "Player HP: " + pHP+"\n";
                queue += "Robot HP: " + eHP+"\n";
                JOptionPane.showMessageDialog(null, queue); //displays updates to what happens
            }
            count++;
        }
        JOptionPane.showMessageDialog(null, "Alas, but even our most deserving heroes come to an end. Score: "+count);
        /*int rc = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation",
                -1, 1, null, buttons, buttons[2]);*/
    }

}
