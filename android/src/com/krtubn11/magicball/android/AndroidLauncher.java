package com.krtubn11.magicball.android;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.krtubn11.magicball.MagicBall;

public class AndroidLauncher extends FragmentActivity implements AndroidFragmentApplication.Callbacks {

	private AdView adView;
	private GameFragment gameFragment;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//initialize(new MagicBall(), config);

		setContentView(R.layout.main_layout);

		GameFragment fragment = new GameFragment();
		FragmentTransaction tr = getSupportFragmentManager().beginTransaction();
		tr.replace(R.id.GameView,fragment);
		tr.commit();
		setAdMob();
	}

	private void setAdMob(){
		AdView mAdView = (AdView) findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);


	}

	@Override
	public void exit() {

	}
}
