package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Created by Roma-Alisa on 9/27/2015.
 */
public class Font extends Actor{
    private SpriteBatch batch;
    private BitmapFont font;
    private String message;
    private GlyphLayout layout;
    private float deltaFade;


    public Font(){
        this.create();
    }

    public void create () {

        deltaFade = 0;
        batch = new SpriteBatch();
        message = " Ask the "+"\n" + " wizard!!";
        font = new BitmapFont(Gdx.files.internal("font/white.fnt"),false);
        font.getData().setScale(Gdx.graphics.getWidth()/(480f));

    }

    public void act () {
        batch.begin();
        layout = new GlyphLayout(font, message);

        fadeIn();

        //float deltaX = Resources.getBodyBall().getPosition().x * Constants.SCREEN_RATIO_WIDTH + Gdx.graphics.getWidth() / 2f - layout.width / 2;
        //float deltaY = (Resources.getBodyBall().getPosition().y + 3) * Constants.SCREEN_RATIO_HEIGHT + Gdx.graphics.getHeight() / 2f - layout.height / 2;

        font.draw(batch,
                message,
                Resources.getBodyBall().getPosition().x * Constants.SCREEN_RATIO_WIDTH + Gdx.graphics.getWidth() / 2f - layout.width / 2,
                Gdx.graphics.getHeight()/(3.4f));
        batch.end();
    }

    public void setDeltaFade(float delta) {
        this.deltaFade = delta;
    }

    private void fadeIn() {
        if(deltaFade < (1.2f)*(Gdx.graphics.getWidth()/(480f))) {
            deltaFade += 0.025f;
            font.getData().setScale(deltaFade);
        }
    }

    public void setStringMessage(String message){
        this.message = message;
    }


    public void dispose() {
        batch.dispose();
        font.dispose();

    }
}
