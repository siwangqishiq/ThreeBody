package com.xinlan.sheering;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * 
 * @author Administrator
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LwjglApplicationConfiguration config= new LwjglApplicationConfiguration();
		config.fullscreen = false;
		config.width=1000;
		config.height = 600;
		config.title="�����˶�";
		new LwjglApplication(new ThreeBodyApp(),config);
	}

}//end class
