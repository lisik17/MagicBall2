package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by Roma-Alisa on 9/26/2015.
 */


public class Shake extends Actor{

    private float xGrav;
    private float yGrav;
    private float zGrav;

    private Messages messages;
    public ShakeState shakeState;
    private long lastShakeTime;
    private float ballAngularVelocity;
    private AnimationManager animation;

    public enum ShakeState {
        STILL,SHAKE_START,SHAKE_STOP,SHAKE_MIDDLE;
    }

    public Shake(){
        this.messages = new Messages();
        animation = new AnimationManager();

        shakeState = ShakeState.STILL;
        lastShakeTime = TimeUtils.nanoTime();
        detectShake();
    }

    private void detectShake() {
        xGrav = Gdx.input.getAccelerometerX() / Constants.GRAVITY_EARTH;
        yGrav = Gdx.input.getAccelerometerY() / Constants.GRAVITY_EARTH;
        zGrav = Gdx.input.getAccelerometerZ() / Constants.GRAVITY_EARTH;

        float gForce = (float) Math.sqrt((xGrav * xGrav) + (yGrav * yGrav) + (zGrav * zGrav));

        if(gForce >= 2.5 ){
            shakeState = ShakeState.SHAKE_START;
            Resources.getFont().setDeltaFade(0);
            Resources.getFont().setStringMessage("");

            Gdx.input.vibrate(200);
            Resources.getBodyBall().setAngularVelocity(3f);

        }
        if(shakeState == ShakeState.SHAKE_START && gForce < 2.5f) {
            shakeState = ShakeState.SHAKE_MIDDLE;

            Resources.getSoundManager().stopSound();
            Resources.getSoundManager().playSound();

            lastShakeTime = TimeUtils.nanoTime();
        }

        if(shakeState == ShakeState.SHAKE_MIDDLE) {
            if (longTimePassed()) {
                shakeState = ShakeState.SHAKE_STOP;
            }
        }
    }

    private boolean longTimePassed() {
        return TimeUtils.nanoTime() - lastShakeTime > 500000000;
    }

    @Override
    public void act(float delta) {

        detectShake();
        startEffectOnShake();
        stopEffectAfterShake();
    }

    private void startEffectOnShake() {
        if(shakeState == ShakeState.SHAKE_STOP){
            Resources.getFont().setStringMessage(messages.getRandomMessage());
            shakeState = ShakeState.STILL;
        }
    }

    private void stopEffectAfterShake() {
        ballAngularVelocity = Resources.getBodyBall().getAngularVelocity();
        if(shakeState == ShakeState.STILL){
            if(ballAngularVelocity > 0) {
                Resources.getBodyBall().setAngularVelocity(ballAngularVelocity - 0.05f);
                Rumble.rumble();

                Resources.setStartAnim(true);
                shakeState = ShakeState.STILL;
            }else{
                Resources.setStartAnim(false);
                Resources.getBackgroundSprite().setPosition(0, 0);
            }
        }
    }


    public void dispose(){

    }
}
