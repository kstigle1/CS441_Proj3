package com.stigler.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CS441Proj3 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, img2, img3, img4, img5;
	Singleton single;
	InProcess inProc;
	BitmapFont textBox, winMsg;
	GlyphLayout layout, layout2, layout3;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("monkey3.png");
		img2 = new Texture("bananas.png");
		img3 = new Texture("backgroundsky.jpg");
		img4 = new Texture("backgroundground.jpg");
		img5 = new Texture("tree.png");


		single = Singleton.getInstance();
		inProc = new InProcess();
		Gdx.input.setInputProcessor(inProc);

		textBox = new BitmapFont();
		textBox.setColor(Color.LIGHT_GRAY);
		textBox.getData().setScale(5);
		layout = new GlyphLayout(textBox, "Press and hold monkey then");
		layout2 = new GlyphLayout(textBox, "release to make him climb!!!");

		winMsg = new BitmapFont();
		winMsg.setColor(Color.RED);
		winMsg.getData().setScale(10);
		layout3 = new GlyphLayout(winMsg, "WINNER!!!");
		single.didWin = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor((float).33, (float).73, (float).95, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tick();
		single.y1 += single.dy1;
		batch.begin();
		batch.draw(img4, 0, 0, single.screenW, single.groundY); //ground
		batch.draw(img3, 0, single.groundY, single.screenW, single.screenH-single.groundY); //sky
		batch.draw(img5, 0, single.groundY-115, single.screenW, single.screenH-single.groundY+225); //tree
		batch.draw(img, single.x1, single.y1, single.picW1, single.picH); //monkey
		batch.draw(img2, single.x2, single.y2, single.picW2, single.picH); //bananas
		textBox.draw(batch, layout, (single.screenW/2) - (layout.width/2), 200);
		textBox.draw(batch, layout2, (single.screenW/2) - (layout2.width/2), 100);
		if (single.didWin == 1)
		{
			winMsg.draw(batch, layout3, (single.screenW/2) - (layout3.width/2), single.screenH/2);
		}
		batch.end();
	}

	public void tick()
	{

		if (single.y1 >= single.y2 - single.picH + 50)
		{
			single.dy1 = 0;
			single.moveTo = single.starting-1;
			single.moving = false;
			single.y1 = single.starting;
			single.didWin = 1;
		}
		else if (single.y1 == single.moveTo + single.starting + 1)
		{
			single.dy1 = -1;
		}
		else if (single.y1 == single.starting && single.moving == true)
		{
			single.dy1 = 0;
			single.moveTo = single.starting-1;
			single.moving = false;
		}
		else if (single.moveTo != single.starting-1 && single.moving == false)
		{
			single.dy1 = 1;
			single.moving = true;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		img2.dispose();
		img3.dispose();
		img4.dispose();
		img5.dispose();
		textBox.dispose();
		winMsg.dispose();
	}

	@Override
	public void resize(int width, int height)
	{
		single.screenW = width;
		single.screenH = height;
		single.x1 = (width/2) - (single.picW1/2);
		single.y1 = (height/7);
		single.x2 = (width/2) - (single.picW2/2);
		single.y2 = (single.screenH - single.y1 - single.picH);
		single.moveTo = (height/7)-1;
		single.starting = (height/7);
		single.groundY = single.y1+50;
	}
}
