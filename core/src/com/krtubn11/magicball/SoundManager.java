package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Roma-Alisa on 13/10/15.
 */
public class SoundManager {
    private Sound stormSound;
    private long soundId;



    public SoundManager(){
        stormSound = Gdx.audio.newSound(Gdx.files.internal("sound/storm.mp3"));

    }


    public void dispose() {
        stormSound.dispose();
    }

    public void playSound(){
        if(Resources.getButton().isSoundOn) {
            soundId = stormSound.play();
        }

    }

    public void stopSound(){
        if(Resources.getButton().isSoundOn) {
            stormSound.stop();
        }
    }
}
