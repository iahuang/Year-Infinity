package com.ian.yrinf;

import java.io.StringWriter;
import java.util.ArrayList;

import org.json.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Editor {
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	Room room = new Room(400,600);
	JSONObject jobj = new JSONObject();
	String load = "";
	public static String escapeQuotes(String myString) {
		 char[] quote=new char[]{'"'};
		 char[] escapedQuote=new char[]{'\\' , '"'};
		 return myString.replace(new String(quote), new String(escapedQuote));
	}
	public void update(SpriteBatch batch) {
		float mx = Gdx.input.getX();
		float my = 600-Gdx.input.getY();
		String tex = Tile.getTextureFromID(0);

		if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			room.tiles.add(new Tile(mx,my,0));
		}
		if (Gdx.input.isKeyJustPressed(Keys.E)) { // Export
			try {
				JSONArray array = new JSONArray();
				for (Tile t : room.tiles) {
					JSONObject jsonTile = new JSONObject();
					jsonTile.put("x", t.x);
					jsonTile.put("y", t.x);
					jsonTile.put("id", t.id);
					jsonTile.put("scale", t.scale);
					array.put(jsonTile);
				}
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
		
		
		room.draw(batch);
		
	}
}