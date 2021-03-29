package com.example.myapplication;

import java.util.ArrayList;

public class Text {
    private String spell;
    private int id;

    public String getSpell() {
        return spell;
    }
    public int getId() {
        return id;
    }

    public Text(String spell, int id) {
        this.spell = spell;
        this.id=id;
    }
    public static ArrayList<Text> createNumbers(){
        ArrayList<Text> list=new ArrayList<>();
        list.add(new Text("One", R.drawable.number_one));
        list.add(new Text("Two", R.drawable.number_two));
        list.add(new Text("Three", R.drawable.number_three));
        list.add(new Text("Four", R.drawable.number_four));
        list.add(new Text("Five", R.drawable.number_five));
        list.add(new Text("Six", R.drawable.number_six));
        list.add(new Text("Seven", R.drawable.number_seven));
        list.add(new Text("Eight", R.drawable.number_eight));
        list.add(new Text("Nine", R.drawable.number_nine));
        return list;

    }
    public static ArrayList<Text> createcolors(){
        ArrayList<Text> list=new ArrayList<>();
        list.add(new Text("Red",R.drawable.color_red));
        list.add(new Text("Yellow",R.drawable.color_mustard_yellow));
        list.add(new Text("Black",R.drawable.color_black));
        list.add(new Text("Green",R.drawable.color_green));
        list.add(new Text("Brown",R.drawable.color_brown));

        list.add(new Text("Gray",R.drawable.color_gray));
        list.add(new Text("White",R.drawable.color_white));
        return list;
    }

}
