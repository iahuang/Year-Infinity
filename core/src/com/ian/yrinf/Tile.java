package com.ian.yrinf;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
	float x;
	float y;
	int id;
	float scale = 2;
	float rot = 0;
	Sprite spr;
	static String[] spriteIndex = new String[] {
		"tile/no.png",
		"tile/flowey.png",
		"build/house_generic.png"
	};
	static Integer[] solidIndex = new Integer[] {
		1,
		0,
		1,
	};
	public static String getTextureFromID(int id) {
		return spriteIndex[id];
	}
	public Tile(float ix, float iy, int iid, float irot) {
		x = ix;
		y = iy;
		rot = irot;
		id = iid;
		spr = new Sprite(new Texture(getTextureFromID(id)));
	}
	public Tile(float ix, float iy, int iid, float irot, float iscale) {
		x = ix;
		y = iy;
		id = iid;
		scale = iscale;
		spr = new Sprite(new Texture(getTextureFromID(id)));
	}
	public void update() {
		spr.setPosition(x, y);
		spr.setScale(scale);
		spr.setRotation(rot);
	}
	public void draw(SpriteBatch batch) {
		spr.draw(batch);
	}
	public String toString() {
		return "";
	}
}