package com.krtubn11.magicball;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Roma-Alisa on 9/29/2015.
 */
public class Wall extends Actor{
    private BodyDef bodyDef;
    private ChainShape chainShape;
    private Body bodyWalls;
    private FixtureDef fixtureDef;

    public Wall(){
        createBodyWall();
    }

    private void createBodyWall() {
        //body def
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        bodyDef.position.set(0,0);

        //ball shape
        chainShape = new ChainShape();
        chainShape.createChain(new Vector2[]{new Vector2(-13.5f, 23), new Vector2(-13.5f, -23)});

        //fixture def
        fixtureDef = new FixtureDef();
        fixtureDef.shape = chainShape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .05f;

        //creating body + fixture
        bodyWalls = Resources.getWorld().createBody(bodyDef);
        bodyWalls.createFixture(fixtureDef);

        //WALL RIGHT
        chainShape = new ChainShape();
        chainShape.createChain(new Vector2[]{new Vector2(13.5f, 23), new Vector2(13.5f, -23)});

        //fixture def
        fixtureDef = new FixtureDef();
        fixtureDef.shape = chainShape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .05f;

        bodyWalls.createFixture(fixtureDef);

        //WALL TOP
        chainShape = new ChainShape();
        chainShape.createChain(new Vector2[]{new Vector2(13.5f, 23), new Vector2(-13.5f, 23)});

        //fixture def
        fixtureDef = new FixtureDef();
        fixtureDef.shape = chainShape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .05f;

        bodyWalls.createFixture(fixtureDef);

        //WALL BOTTOM
        chainShape = new ChainShape();
        chainShape.createChain(new Vector2[]{new Vector2(13.5f, -23), new Vector2(-13.5f, -23)});

        //fixture def
        fixtureDef = new FixtureDef();
        fixtureDef.shape = chainShape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = .25f;
        fixtureDef.restitution = .05f;

        bodyWalls.createFixture(fixtureDef);
    }



    public void dispose(){
        chainShape.dispose();
    }
}
