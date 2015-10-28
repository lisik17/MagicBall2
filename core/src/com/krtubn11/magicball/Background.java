package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Roma-Alisa on 9/25/2015.
 */
public class Background extends Actor{
    private Texture background;
    private Sprite sprite;
    private SpriteBatch batch;

    public Background(){
        background = new Texture(Gdx.files.internal("wiz1.png"));
        sprite = new Sprite(background);
        sprite.setSize(Constants.SCREEN_PIXELS_WIDTH + 40, Constants.SCREEN_PIXELS_HEIGHT + 100);
        sprite.setPosition(0,0);
        batch = new SpriteBatch();

        Resources.setBackgroundSprite(sprite);
    }

    @Override
    public void act(float delta) {
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    public void dispose(){
        background.dispose();
        sprite.getTexture().dispose();
        batch.dispose();
    }
}
