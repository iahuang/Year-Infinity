package com.ian.yrinf;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class YrInfMain extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer sr;
	int year = -1000;
	Editor editor;
	@Override
	public void create () {
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		editor = new Editor();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		editor.update(batch,sr);
		batch.end();
	}
}
