package com.ian.yrinf;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
	float x;
	float y;
	Sprite spr;
	static String[] spriteIndex = new String[] {
		"build/house_generic.png"
	};
	public static String getTextureFromID(int id) {
		return spriteIndex[id];
	}
	public void Tile(float ix, float iy, String tex) {
		x = ix;
		y = iy;
		spr = new Sprite(new Texture(tex));
	}
	public void update() {
		spr.setPosition(x, y);
	}
	public void draw(SpriteBatch batch) {
		spr.draw(batch);
	}
}