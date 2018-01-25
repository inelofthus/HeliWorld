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
    private Array<Skydiver> skydivers;
    private static final int SKYDIVER_COUNT = 3;

    public Task3(GameStateManager gsm){
        super(gsm);
        helicopter = new HelicopterAnimation(50, 200);
        bg = new Texture("bg.png");
        skydivers = new Array<Skydiver>();
        for(int i = 1; i <= SKYDIVER_COUNT; i++){
            skydivers.add(new Skydiver());
        }
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        //handleInput();
        helicopter.update(dt);
        Skydiver prevSkydiver = null;
        for(Skydiver skydiver : skydivers) {
            skydiver.update(dt);
            if (skydiver.collides(helicopter.getBounds())) {
                helicopter.flipVelocity();
                helicopter.flipHeliAnimationX();
                skydiver.flipVelocity();
            } else if(prevSkydiver != null){
                if(skydiver.collides(prevSkydiver.getBounds())){
                    prevSkydiver.flipVelocity();
                    skydiver.flipVelocity();
                }
            }

            prevSkydiver = skydiver;
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(helicopter.getHeli(), helicopter.getPosition().x, helicopter.getPosition().y);
        for(Skydiver skydiver : skydivers){
            sb.draw(skydiver.getSkydiver(), skydiver.getPosition().x, skydiver.getPosition().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        helicopter.dispose();
    }

}
