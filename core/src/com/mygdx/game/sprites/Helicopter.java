package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;

/**
 * Created by Ine on 22.01.2018.
 */

public class Helicopter {
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    //private Animation birdAnimation;
    private Texture texture;
    private Sound flap;
    private Sprite sprite;

    private Texture helicopter;
    public Helicopter(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(-100, 100, 0);
        texture = new Texture("heli1.png");
        sprite = new Sprite(texture);

        //birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        //bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
        //bounds = new Rectangle(x, y, texture.getWidth()/3, texture.getHeight());
        //flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt){
        //birdAnimation.update(dt);
        if(position.y <= 0 || position.y > HelicopterTasks.HEIGHT / 2 - texture.getHeight()) {
            velocity.y = -velocity.y;
        }
        if(position.x <= 0 || position.x > HelicopterTasks.WIDTH / 2 - texture.getWidth()) {
            velocity.x = -velocity.x;
            sprite.flip(true, false);

        }
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);

        velocity.scl(1/dt);

        //bounds.setPosition(position.x, position.y);
    }


    public void setPosition(int x, int y){
        this.position.x = x/2;
        this.position.y = y/2;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Sprite getHeli() {
        return sprite;
    }

    public void dispose(){
        texture.dispose();
    }

}
