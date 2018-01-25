package com.mygdx.game.states;

/**
 * Created by Ine on 24.01.2018.
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.HelicopterAnimation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.HelicopterTasks;
import com.mygdx.game.sprites.Skydiver;

/**
 * Created by Ine on 24.01.2018.
 */

public class Task3 extends State{

    private HelicopterAnimation helicopter;
    private Texture bg;
    private Skydiver skydiver;

    public Task3(GameStateManager gsm){
        super(gsm);
        helicopter = new HelicopterAnimation(50, 200);
        skydiver = new Skydiver();
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        //handleInput();
        helicopter.update(dt);
        skydiver.update(dt);
        if(skydiver.collides(helicopter.getBounds())){
            helicopter.flipVelocity();
            helicopter.flipHeliAnimationX();
            skydiver.flipVelocity();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(helicopter.getHeli(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.draw(skydiver.getSkydiver(), skydiver.getPosition().x, skydiver.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        helicopter.dispose();
    }

}
