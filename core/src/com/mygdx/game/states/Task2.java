package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.sprites.Helicopter2;

/**
 * Created by jonas on 24/01/2018.
 */


public class Task2 extends State {
    private Helicopter2 helicopter2;
    private Texture bg;
    protected Task2(GameStateManager gsm) {
        super(gsm);
        helicopter2 = new Helicopter2(50, 200);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        helicopter2.setPos(touchPos);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(helicopter2.getHeli(), helicopter2.getPosition().x, helicopter2.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
