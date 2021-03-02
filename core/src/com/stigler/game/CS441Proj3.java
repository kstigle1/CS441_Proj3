package com.stigler.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CS441Proj3 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Singleton single;
	InProcess inProc;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		single = Singleton.getInstance();
		inProc = new InProcess();
		Gdx.input.setInputProcessor(inProc);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor((float).33, (float).73, (float).95, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, single.x, single.y, single.picW, single.picH);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		single.screenW = width;
		single.screenH = height;
		single.x = (width/2) - (single.picW/2);
		single.y = (height/7);
	}
}
