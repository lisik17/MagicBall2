package com.krtubn11.magicball;

public class MagicBall extends BasicScreen {

	private Ball ball;
	private Shake shake;
	private Font font;
	private Background background;
	private com.krtubn11.magicball.AnimationManager animation;
	private SoundManager soundManager;

	private Button button;

	@Override
	public void create () {
		super.create();

		ball  = new Ball();
		background = new Background();
		font  = new Font();
		Resources.setFont(font);
		shake = new Shake();

		animation = new AnimationManager();

		soundManager = new SoundManager();
		Resources.setSoundManager(soundManager);

		button = new Button();
		Resources.setButton(button);


	}

	@Override
	public void render () {
		super.render();
		ball.draw();
		animation.act(10f);
		font.act();
		background.act(10f);
		shake.act(10f);
		//
		ball.act(10f);
		button.act();
	}


	@Override
	public void dispose() {
		ball.dispose();
		background.dispose();
		font.dispose();
		shake.dispose();
		animation.dispose();
		soundManager.dispose();
		button.dispose();

		super.dispose();
	}
}
