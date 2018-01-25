package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;

import java.util.Random;

/**
 * Created by Ine on 25.01.2018.
 */

public class Skydiver {
    private Texture skydiver;
    private Rectangle bounds;
    private Vector3 position;
    private Vector3 velocity;
    private Random rand;

    public Skydiver(){
        rand = new Random();
        //position = new Vector3(rand.nextFloat(), rand.nextFloat(), 0);
        position = new Vector3(100, 30, 0);
        skydiver = new Texture("skydiver.png");
        bounds = new Rectangle(position.x, position.y, skydiver.getWidth(), skydiver.getHeight());
        velocity = new Vector3(100, 100, 0);
    }

    public void update(float dt){
        if(position.y <= 0 || position.y > HelicopterTasks.HEIGHT / 2 - skydiver.getHeight()) {
            velocity.y = -velocity.y;
        }
        if(position.x <= 0 || position.x > HelicopterTasks.WIDTH / 2 - skydiver.getWidth()) {
            velocity.x = -velocity.x;
        }
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition(){
        return position;
    }

    public Texture getSkydiver(){
        return skydiver;
    }

    public boolean collides(Rectangle player){
        return player.overlaps(bounds);
    }

    public void flipVelocity(){
        velocity.y = -velocity.y;
        velocity.x = -velocity.x;
    }
}
