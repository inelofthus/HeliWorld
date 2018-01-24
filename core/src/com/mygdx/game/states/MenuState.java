package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HelicopterTasks;
import com.mygdx.game.sprites.Helicopter;

/**
 * Created by Ine on 22.01.2018.
 */

public class MenuState extends State {
    private Texture background;
    private Texture bg1;
    private Texture bg2;
    private Texture task1Btn;
    private Texture task2Btn;
    private Texture task3Btn;
    private int count;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, HelicopterTasks.WIDTH / 2, HelicopterTasks.HEIGHT / 2);
        bg1 = new Texture("bg.png");
        bg2 = new Texture("bg_inverted.png");
        background = bg1;
        task1Btn = new Texture("taskBtn1.png");
        task2Btn = new Texture("taskBtn2.png");
        task3Btn = new Texture("taskBtn3.png");
        count = 0;
    }

    @Override
    public void handleInput() {
        float leftXBound = cam.position.x - task1Btn.getWidth() / 2;
        float rightXBound = cam.position.x + task1Btn.getWidth() / 2;
        if(Gdx.input.justTouched() && isOnTask1Btn(leftXBound, rightXBound)){
            gsm.set(new Task1(gsm));
            dispose();
        } else if(Gdx.input.justTouched() && isOnTask2Btn(leftXBound, rightXBound)){
            gsm.set(new Task2(gsm));
            dispose();
            //System.out.println("Task 2");
        }
        else if(Gdx.input.justTouched() && isOnTask3Btn(leftXBound, rightXBound)){
            gsm.set(new Task3(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        switchBg();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(task1Btn, cam.position.x - task1Btn.getWidth() / 2, cam.position.y + 100);
        sb.draw(task2Btn, cam.position.x - task2Btn.getWidth() / 2, cam.position.y);
        sb.draw(task3Btn, cam.position.x - task3Btn.getWidth() / 2, cam.position.y - 100);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        task1Btn.dispose();
        System.out.print("Menu State Disposed");
    }

    private boolean isOnTask1Btn(float leftXBound, float rightXBound){
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        return (touchPos.x > leftXBound
                && touchPos.x < rightXBound
                && touchPos.y > cam.position.y + 100
                && touchPos.y < cam.position.y + 100 + task1Btn.getHeight());
    }

    private boolean isOnTask2Btn(float leftXBound, float rightXBound){
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        return (touchPos.x > leftXBound
                && touchPos.x < rightXBound
                && touchPos.y > cam.position.y
                && touchPos.y < cam.position.y + task1Btn.getHeight());
    }

    private boolean isOnTask3Btn(float leftXBound, float rightXBound){
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(touchPos);
        return (touchPos.x > leftXBound
                && touchPos.x < rightXBound
                && touchPos.y > cam.position.y - 100
                && touchPos.y < cam.position.y - 100 + task1Btn.getHeight());
    }

    private void switchBg(){
        count++;
        if(background == bg1 && count > 10){
            background = bg2;
            count = 0;
        } else if (background == bg2 && count > 10){
            background = bg1;
            count = 0;
        }
    }
}
