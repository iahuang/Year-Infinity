package com.ian.yrinf;

import java.util.ArrayList;

import org.json.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
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
	float r;
	float g;
	float b;
	
	int winx = 800;
	int winy = 600;

	public Room() {
		batch = new SpriteBatch();
		
	}
	public Room(String json) {
		loadJSON(json);
	}
	public Room(int roomID) {
		loadJSON(Gdx.files.internal("rooms/"+roomID+".json").readString());
	}
	public void loadJSON(String json) {
		JSONObject roomData;
		try {
			roomData = new JSONObject(json);
			r = (float) roomData.getDouble("r");
			g = (float) roomData.getDouble("g");
			b = (float) roomData.getDouble("b");;
			JSONArray tileData = roomData.getJSONArray("tiles");
			
			for (int ind=0;ind<tileData.length();ind++) {
				JSONObject rawTile = tileData.getJSONObject(ind);
				
				float x = rawTile.getInt("x");
				float y = rawTile.getInt("y");
				float scale = rawTile.getInt("scale");
				float rot = rawTile.getInt("rot");
				int id = rawTile.getInt("id");
				tiles.add(new Tile(x,y,id,rot,scale));
				
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void draw(SpriteBatch batch) {
		Gdx.gl.glClearColor(r, g, b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (int y=winy;y>0;y-=2) {
			for (Tile t : tiles) {
				if ((int) t.y-t.y%2 == y) {
					t.update();
					t.draw(batch);
				}
				
			}
		}
		
	}
	
	
}