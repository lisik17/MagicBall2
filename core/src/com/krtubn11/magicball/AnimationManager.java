package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Created by Roma-Alisa on 10/1/2015.
 */
public class AnimationManager extends Actor {
    private SpriteBatch batch;
    private TextureAtlas atlas;
    private Animation animation;
    private float timePassed;
    private Sprite sprite;

    private float ballCordsPixelsX;
    private float ballCordsPixelsY;

    public AnimationManager(){
        batch = new SpriteBatch();
        atlas = new TextureAtlas(Gdx.files.internal("animation/lightening.pack"));
        animation = new Animation(1/6f,atlas.getRegions());
        sprite = new Sprite();
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        animate();
    }

    private void animate() {
        if(Resources.isStartAnim()) {
            batch.begin();
            timePassed += Gdx.graphics.getDeltaTime();
            sprite.setRegion(animation.getKeyFrame(timePassed, true));
            metersToPixels();
            batch.draw(sprite,
                    ballCordsPixelsX,
                    ballCordsPixelsY,
                    (Constants.BALL_PICTURE_RADIUS - 4) * Constants.SCREEN_RATIO_WIDTH, (Constants.BALL_PICTURE_RADIUS - 4) * Constants.SCREEN_RATIO_HEIGHT);

            batch.end();
        }
    }

    private void metersToPixels() {
        ballCordsPixelsX = (Resources.getBodyBall().getPosition().x+ 1) * Constants.SCREEN_RATIO_WIDTH + Gdx.graphics.getWidth() / 2f ;
        ballCordsPixelsY = Resources.getBodyBall().getPosition().y * Constants.SCREEN_RATIO_HEIGHT + Gdx.graphics.getHeight()/ 2f;

        ballCordsPixelsX = ballCordsPixelsX - Constants.BALL_PICTURE_RADIUS*Constants.SCREEN_RATIO_WIDTH/2f;
        ballCordsPixelsY = ballCordsPixelsY - Constants.BALL_PICTURE_RADIUS*Constants.SCREEN_RATIO_HEIGHT/2f;
    }

    public void dispose(){
        batch.dispose();
        atlas.dispose();
    }
}

