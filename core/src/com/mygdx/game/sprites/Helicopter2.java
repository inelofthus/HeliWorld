package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;

/**
 * Created by jonas on 24/01/2018.
 */

public class Helicopter2 {
    private Vector3 position;
    //private Vector3 velocity;
    private Rectangle bounds;
    private Texture texture;
    Sprite sprite;

    private Texture helicopter;
    public Helicopter2(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("heli1.png");
        sprite = new Sprite(texture);
    }

    public void update(float dt){

    }
    public void setPos(Vector3 touchPos){
        //birdAnimation.update(dt);
        float x = touchPos.x;
        float y = touchPos.y;

        if(x <= 0 || x > HelicopterTasks.WIDTH / 2 - texture.getWidth()) {
            x = x <= 0 ? 0 : HelicopterTasks.WIDTH;
        }
        if(y <= 0 || y > HelicopterTasks.HEIGHT / 2 - texture.getHeight()) {
            y = y <= 0 ? 0 : HelicopterTasks.HEIGHT;
        }
        position.set(x, y, 0);
    }
        /*velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);

        velocity.scl(1/dt); */

        //bounds.setPosition(position.x, position.y);


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
