package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.HelicopterTasks;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = HelicopterTasks.WIDTH;
		config.height = HelicopterTasks.HEIGHT;
		config.title = HelicopterTasks.title;
		new LwjglApplication(new HelicopterTasks(), config);
	}
}
