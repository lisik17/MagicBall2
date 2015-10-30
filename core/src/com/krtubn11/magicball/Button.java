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

    private Stage stage;
    private TextButton buttonSound, buttonLike, buttonRate;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    public Boolean isSoundOn;


    public Button(){
        create();
    }

    private void create() {

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        skin = new Skin();

        buttonAtlas = new TextureAtlas(Gdx.files.internal("button/sound/button.pack"));
        skin.addRegions(buttonAtlas);

        initSoundButton();
        initLikeButton();
        initRateButton();

    }

    private void initRateButton() {
        buttonAtlas = new TextureAtlas(Gdx.files.internal("button/rate/ratePack.pack"));
        skin.addRegions(buttonAtlas);

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;

        textButtonStyle.up = skin.getDrawable("rate");
        textButtonStyle.down = skin.getDrawable("rate");
        textButtonStyle.checked = skin.getDrawable("rate");

        buttonRate = new TextButton("", textButtonStyle);
        buttonRate.setPosition(Gdx.graphics.getWidth() * (.02f), Gdx.graphics.getHeight() * (.902f));
        buttonRate.setSize(Gdx.graphics.getHeight() * (.1f), Gdx.graphics.getHeight() * (.1f));
        stage.addActor(buttonRate);

        buttonRate.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.shagunstudios.racinggame");
            }
        });
    }

    private void initLikeButton() {
        buttonAtlas = new TextureAtlas(Gdx.files.internal("button/like/likePack.pack"));
        skin.addRegions(buttonAtlas);

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;

        textButtonStyle.up = skin.getDrawable("like");
        textButtonStyle.down = skin.getDrawable("like");
        textButtonStyle.checked = skin.getDrawable("like");

        buttonLike = new TextButton("", textButtonStyle);
        buttonLike.setPosition(Gdx.graphics.getWidth() * (.2f), Gdx.graphics.getHeight() * (.9f));
        buttonLike.setSize(Gdx.graphics.getHeight() * (.1f), Gdx.graphics.getHeight() * (.1f));
        stage.addActor(buttonLike);

        buttonLike.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.shagunstudios.racinggame");
            }
        });
    }

    private void initSoundButton() {
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;

        textButtonStyle.up = skin.getDrawable("soundOn");
        textButtonStyle.down = skin.getDrawable("soundOff");
        textButtonStyle.checked = skin.getDrawable("soundOff");

        buttonSound = new TextButton("", textButtonStyle);
        buttonSound.setPosition(Gdx.graphics.getWidth() * (.8f), Gdx.graphics.getHeight() * (.9f));
        buttonSound.setSize(Gdx.graphics.getHeight() * (.1f), Gdx.graphics.getHeight() * (.1f));
        stage.addActor(buttonSound);

        isSoundOn = true;


        buttonSound.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!isSoundOn) {
                    isSoundOn = true;
                } else {
                    Resources.getSoundManager().stopSound();
                    isSoundOn = false;
                }
            }
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
