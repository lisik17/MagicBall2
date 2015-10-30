package com.krtubn11.magicball.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.krtubn11.magicball.MagicBall;

/**
 * Created by Roma-Alisa on 16/10/15.
 */
//public class GameFragment extends AndroidFragmentApplication {
public class GameFragment extends AndroidFragmentApplication{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initializeForView(new MagicBall());
    }


}
