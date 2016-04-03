package com.ian.yrinf;

import java.util.ArrayList;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Room {
	ArrayList<Tile> tiles;
	Music bgmus;
	Viewport viewport;
	OrthographicCamera camera;
	int bx;
	int by;
	SpriteBatch batch;
	
	public void Room(ArrayList<Tile> itiles, Music ibgmus, int ibx, int iby) {
		tiles = itiles;
		bgmus = ibgmus;
		bx = ibx;
		by = iby;
		camera = new OrthographicCamera();
		viewport = new FitViewport(bx, by, camera);
		batch = new SpriteBatch();
		
	}
	public void draw() {
		batch.begin();
		for (Tile t : tiles) {
			t.update();
			t.draw(batch);
			
		}
		batch.end();
	}
	
	
}