package com.krtubn11.magicball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Created by Roma-Alisa on 9/24/2015.
 */
public class Ball extends Actor {
    private BodyDef bodyDef;
    private CircleShape circleShape;
    private Body bodyBall;

    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    public Ball(){
        createBodyBall();
        setPicture();
    }

    @Override
    public void setPosition(float x, float y) {
        bodyBall.setTransform(x, y, 0);
    }

    private void createBodyBall(){
        //body def
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(.7f,-12);

        //ball shape
        circleShape = new CircleShape();
        circleShape.setRadius(Constants.BALL_RADIUS);

        //fixture def
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = .05f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .05f;

        //creating body + fixture
        bodyBall = Resources.getWorld().createBody(bodyDef);
        bodyBall.createFixture(fixtureDef);

        Resources.setBodyBall(bodyBall);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {

        super.act(delta);

        //bodyBall.applyForceToCenter(30,30,true);

/*        Vector2 linearVelocity = bodyBall.getLinearVelocity();
        float angle = linearVelocity.angle();
        bodyBall.setTransform(bodyBall.getPosition(), (float) (angle * MathUtils.degreesToRadians));*/
    }

    public void draw(){
        batch.setProjectionMatrix(Resources.getCamera().combined);
        batch.begin();
        sprite.setPosition(bodyBall.getPosition().x - sprite.getWidth() / 2, bodyBall.getPosition().y - sprite.getHeight() / 2);
        sprite.setRotation(bodyBall.getAngle() * MathUtils.radiansToDegrees);
        sprite.draw(batch);
        batch.end();
    }

    private void setPicture(){
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("ball.png"));
        sprite = new Sprite(texture);

        sprite.setSize(Constants.BALL_PICTURE_RADIUS, Constants.BALL_PICTURE_RADIUS);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setCenter(0, 0);
    }

    public void dispose(){
        circleShape.dispose();
        batch.dispose();
        sprite.getTexture().dispose();
        texture.dispose();
    }
}
