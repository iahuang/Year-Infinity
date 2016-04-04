package com.ian.yrinf;

import java.io.StringWriter;
import java.util.ArrayList;

import org.json.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Editor {
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Room room = new Room(0);
	JSONObject jobj = new JSONObject();
	String load = "";
	float rot = 0;
	int tileID = 0;
	int entryTimer = -1;
	int grid = 64;
	boolean showGrid = true;
	int winx = 800;
	int winy = 600;
	Texture origin = new Texture("editor/origin.png");
	Texture gridLines = new Texture("editor/grid.png");
	
	public static int addNumber(int x, int y) {
		if (x == 0) {
			return y;
		}
		return Integer.parseInt(""+x+y);
	}
	public static String escapeQuotes(String myString) {
		 char[] quote=new char[]{'"'};
		 char[] escapedQuote=new char[]{'\\' , '"'};
		 return myString.replace(new String(quote), new String(escapedQuote));
	}

	public void update(SpriteBatch batch,ShapeRenderer sr) {
		float mx = Gdx.input.getX();
		float my = winy-Gdx.input.getY();
		mx-=mx%grid;
		my-=my%grid;
		try {
			String tex = Tile.getTextureFromID(tileID);
		}
		catch (Exception e) {
			tileID = Tile.spriteIndex.length-1;
		}

		if (Gdx.input.justTouched()) {
			boolean found = false;
			for (Tile t : room.tiles) {
				if (t.x == mx && t.y == my && t.id == tileID) {
					found = true;
				}
			}
			if (!found) {
				room.tiles.add(new Tile(mx,my,tileID,rot));
			}
			
		}
		if (Gdx.input.isKeyJustPressed(Keys.DEL)) {
			for (Tile t : room.tiles) {
				if (t.x == mx && t.y == my) {
					room.tiles.remove(t);
					break;
				}
			}
		}
		if (Gdx.input.isKeyJustPressed(Keys.E)) { // Export
			try {
				JSONArray array = new JSONArray();
				for (Tile t : room.tiles) {
					JSONObject jsonTile = new JSONObject();
					jsonTile.put("x", t.x);
					jsonTile.put("y", t.y);
					jsonTile.put("id", t.id);
					jsonTile.put("scale", t.scale);
					jsonTile.put("rot", t.rot);
					array.put(jsonTile);
				}
				jobj.put("r", room.r);
				jobj.put("g", room.g);
				jobj.put("b", room.b);
				jobj.put("tiles", array);
				String out = jobj.toString();
				if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
					System.out.println("Formatting for Java...");
					out = escapeQuotes(out);
				}
				System.out.println(out);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Gdx.input.isKeyPressed(Keys.R)) {
			if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
				room.r-=0.01;
				if (room.r < 0) {
					room.r = 0;
				}
			}
			else {
				room.r+=0.01;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.G)) {
			if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
				room.g-=0.01;
				if (room.g < 0) {
					room.g = 0;
				}
			}
			else {
				room.g+=0.01;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.B)) {
			if (Gdx.input.isKeyPressed(Keys.SHIFT_LEFT)) {
				room.b-=0.01;
				if (room.b < 0) {
					room.b = 0;
				}
			}
			else {
				room.b+=0.01;
			}
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_0)) {
			tileID = addNumber(tileID,0);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_1)) {
			tileID = addNumber(tileID,1);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_2)) {
			tileID = addNumber(tileID,2);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_3)) {
			tileID = addNumber(tileID,3);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_4)) {
			tileID = addNumber(tileID,4);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_5)) {
			tileID = addNumber(tileID,5);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_6)) {
			tileID = addNumber(tileID,6);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_7)) {
			tileID = addNumber(tileID,7);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_8)) {
			tileID = addNumber(tileID,8);
		}
		if (Gdx.input.isKeyJustPressed(Keys.NUM_9)) {
			tileID = addNumber(tileID,9);
		}
		if (Gdx.input.isKeyJustPressed(Keys.C)) {
			tileID = 0;
		}
		
		Gdx.graphics.setTitle("Tile Selected: "+tileID+"  ("+Tile.getTextureFromID(tileID)+")");
		
		for (int x=0;x<winx;x+=64) {
			for (int y=0;y<winy;y+=64) {
				batch.draw(gridLines,x,y);
			}
		}
		room.draw(batch);
		for (Tile t : room.tiles) {
			batch.draw(origin,t.x,t.y);
		}
	}
}