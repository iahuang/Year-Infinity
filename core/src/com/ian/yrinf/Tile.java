package com.ian.yrinf;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
	float x;
	float y;
	int id;
	int scale = 2;
	Sprite spr;
	static String[] spriteIndex = new String[] {
		"build/house_generic.png"
	};
	public static String getTextureFromID(int id) {
		return spriteIndex[id];
	}
	public Tile(float ix, float iy, int id) {
		x = ix;
		y = iy;
		spr = new Sprite(new Texture(getTextureFromID(id)));
	}
	public Tile(float ix, float iy, int id, int iscale) {
		x = ix;
		y = iy;
		scale = iscale;
		spr = new Sprite(new Texture(getTextureFromID(id)));
	}
	public void update() {
		spr.setPosition(x, y);
		spr.setScale(scale);
	}
	public void draw(SpriteBatch batch) {
		spr.draw(batch);
	}
	public String toString() {
		return "";
	}
}