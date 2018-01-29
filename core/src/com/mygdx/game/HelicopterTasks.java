package com.mygdx.game;

import 

public class HelicopterTasks extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String title = "Helicopter";
	private GameStateManager gsm;
	SpriteBatch batch;
	private Music music;
	//Texture img;
	
	@Override
	public void create () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("08_ocho.mp3"));
		music.setLooping(true);
		music.setVolume(0.8f);
		music.play();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
