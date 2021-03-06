package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.HelicopterTasks;
import com.mygdx.game.sprites.Helicopter;
//import com.mygdx.game.sprites.Helicopter;
//import com.mygdx.game.sprites.Tube;

/**
 * Created by Ine on 19.01.2018.
 */

public class Task1 extends State{
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;

    private Helicopter helicopter;
    private Texture bg;

    public Task1(GameStateManager gsm){
        super(gsm);
        helicopter = new Helicopter(50, 200);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {
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
    }

}
