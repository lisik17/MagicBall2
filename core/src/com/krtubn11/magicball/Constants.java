package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;

/**
 * Created by Roma-Alisa on 9/24/2015.
 */
public class Constants {
    //WORLD
    public static final float TIME_STEP = 1/60f;
    public static int VELOCITY_ITERATIONS = 8, POSITION_ITERATIONS = 3;
    public static float GRAVITY_EARTH =  -9.8f;

    //SCREEN SIZE
    public static float SCREEN_RATIO_WIDTH = Gdx.graphics.getWidth()/28;
    public static float SCREEN_RATIO_HEIGHT = Gdx.graphics.getHeight()/45;
    public static float SCREEN_PIXELS_WIDTH = Gdx.graphics.getWidth();
    public static float SCREEN_PIXELS_HEIGHT = Gdx.graphics.getHeight();

    //STRING
    public static float STRING_SIZE_RATIO = Gdx.graphics.getWidth()/2f;

    //BALL
    public static float BALL_RADIUS =  10f;
    public static float BALL_PICTURE_RADIUS =  32f;



}
