package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Roma-Alisa on 14/10/15.
 */
public class Button extends Actor{

    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    public Boolean isSoundOn;


    public Button(){
        create();
    }

    private void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("button/button.pack"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("soundOn");
        textButtonStyle.down = skin.getDrawable("soundOff");
        textButtonStyle.checked = skin.getDrawable("soundOff");
        button = new TextButton("", textButtonStyle);
        button.setPosition(Gdx.graphics.getWidth() * (.8f), Gdx.graphics.getHeight() * (.9f));
        button.setSize(Gdx.graphics.getHeight() * (.1f), Gdx.graphics.getHeight() * (.1f));
        stage.addActor(button);

        isSoundOn = true;

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isSoundOn) {
                    isSoundOn = true;
                } else {
                    Resources.getSoundManager().stopSound();
                    isSoundOn = false;
                }
            }

            ;
        });


    }


    public void act() {
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
        font.dispose();
        skin.dispose();
        buttonAtlas.dispose();

    }
}
