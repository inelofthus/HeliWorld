package com.mygdx.game.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;

/**
 * Created by Ine on 24.01.2018.
 */

public class HelicopterAnimation {

    private Vector3 position;
    private Vector3 velocity;

    Animation heliAnimation;
    private Texture texture;

    Sprite sprite;

    private Texture helicopter;
    public HelicopterAnimation(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(-100, 100, 0);
        texture = new Texture("helisheet.png");
        //sprite = new Sprite(texture);

        heliAnimation = new Animation(new TextureRegion(texture), 4, 0.5f);

    }

    public void update(float dt){
        heliAnimation.update(dt);
        if(position.y <= 0 || position.y > HelicopterTasks.HEIGHT / 2 - texture.getHeight()) {
            velocity.y = -velocity.y;
        }
        if(position.x <= 0 || position.x > HelicopterTasks.WIDTH / 2 - texture.getWidth()/4) {
            for (TextureRegion frame : heliAnimation.getFrames()){
                frame.flip(true, false);
            }
            velocity.x = -velocity.x;

        }
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);

        velocity.scl(1/dt);

    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getHeli() {
        return heliAnimation.getFrame();
    }

    public void dispose(){
        texture.dispose();
    }

}
