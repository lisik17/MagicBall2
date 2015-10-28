package com.krtubn11.magicball;

import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Roma-Alisa on 10/1/2015.
 */
public class Rumble {

    public static void rumble(){
        Resources.getBackgroundSprite().setPosition(MathUtils.random(-23f), 0);
    }

}
