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

/**
 * Created by Ine on 24.01.2018.
 */

public class Task3 extends State{

    private HelicopterAnimation helicopter;
    private Texture bg;

    public Task3(GameStateManager gsm){
        super(gsm);
        helicopter = new HelicopterAnimation(50, 200);
        //Zooms in camera
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        //handleInput();
        helicopter.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(helicopter.getHeli(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        helicopter.dispose();
    }

}
