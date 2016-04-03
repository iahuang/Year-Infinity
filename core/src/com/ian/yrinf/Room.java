package com.ian.yrinf;

import java.util.ArrayList;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Room {
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Music bgmus;
	int bx;
	int by;
	SpriteBatch batch;
	
	
	public Room(int ibx, int iby) {
		bx = ibx;
		by = iby;
		batch = new SpriteBatch();
		
	}
	public void draw(SpriteBatch batch) {
		for (Tile t : tiles) {
			t.update();
			t.draw(batch);
			
		}
	}
	
	
}