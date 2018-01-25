package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;
import com.mygdx.game.sprites.Helicopter;

/**
 * Created by jonas on 24/01/2018.
 */


public class Task2 extends State {
    private Helicopter helicopter;
    private Texture bg;
    protected Task2(GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(100, 200);
        bg = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), HelicopterTasks.HEIGHT - Gdx.input.getY(), 0);
        if(Gdx.input.isTouched()) {
            helicopter.setPosition(setHeliOnXPosition(), setHeliOnYPosition());
        }

    }

    @Override
    public void update(float dt) {
        if(Gdx.input.isTouched()){
            handleInput();
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(helicopter.getHeli(), helicopter.getPosition().x, helicopter.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }

    public int setHeliOnXPosition(){
        int heliMidPointX = (int) helicopter.getHeli().getWidth()/2;
        return Gdx.input.getX() - heliMidPointX;
    }

    public int setHeliOnYPosition(){
        int heliMidPointY = (int) helicopter.getHeli().getHeight()/2;
        return HelicopterTasks.HEIGHT - Gdx.input.getY() - heliMidPointY;
    }
}
