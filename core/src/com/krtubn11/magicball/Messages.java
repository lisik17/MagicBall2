package com.krtubn11.magicball;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Roma-Alisa on 9/26/2015.
 */
public class Messages {

    private Array<String> messages;


    public Messages() {
        messages = new Array<String>();
        initArray();
    }

    private void initArray() {
        messages.add("Yes!");
        messages.add("No!");
        messages.add("Maybe");
        messages.add("No way!");
        messages.add("Never!");
        messages.add("Surely!");
        messages.add("  No"+ "\n"+"chance!");
        messages.add("Are you"+ "\n"+"  sure?");
        messages.add(" Ask"+"\n"+"again!");
        messages.add("Looks"+"\n"+"good!");
    }

    public String getRandomMessage(){

        return messages.get(MathUtils.random(messages.size-1));
    }
}
