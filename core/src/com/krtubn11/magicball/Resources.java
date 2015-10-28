package com.krtubn11.magicball;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Roma-Alisa on 10/1/2015.
 */
public class Resources {
    private static Resources instance = null;

    private static World world;
    private static OrthographicCamera camera;

    private static Font font;
    private static Body bodyBall;
    private static Sprite backgroundSprite;

    private static SoundManager soundManager;
    private static Button button;

    private static boolean startAnim;

    public static boolean isStartAnim() {
        return startAnim;
    }

    public static void setStartAnim(boolean startAnim) {
        Resources.startAnim = startAnim;
    }



    public static Button getButton() {
        return button;
    }

    public static void setButton(Button button) {
        Resources.button = button;
    }



    public static SoundManager getSoundManager() {
        return soundManager;
    }

    public static void setSoundManager(SoundManager soundManager) {
        Resources.soundManager = soundManager;
    }

    public static Resources getInstance() {
        return instance;
    }

    private Resources(){}

    public static Resources getResources(){
        if(instance == null){
            instance = new Resources();
        }
        return instance;
    }

    public static void dispose(){
        world.dispose();
    }

    //GETTERS_SETTERS

    public static World getWorld() {
        return world;
    }

    public static void setWorld(World world) {
        Resources.world = world;
    }

    public static OrthographicCamera getCamera() {
        return camera;
    }

    public static void setCamera(OrthographicCamera camera) {
        Resources.camera = camera;
    }

    public static Body getBodyBall() {
        return bodyBall;
    }

    public static void setBodyBall(Body bodyBall) {
        Resources.bodyBall = bodyBall;
    }

    public static Font getFont() {
        return font;
    }

    public static void setFont(Font font) {
        Resources.font = font;
    }

    public static Sprite getBackgroundSprite() {
        return backgroundSprite;
    }

    public static void setBackgroundSprite(Sprite backgroundSprite) {
        Resources.backgroundSprite = backgroundSprite;
    }
}
