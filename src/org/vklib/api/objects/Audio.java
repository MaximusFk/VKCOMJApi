/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.json.JSONObject;
import org.vklib.api.ObjectType;
/**
 *
 * @author maximusfk
 */
public class Audio implements IVKObject {
	int id;
	int owner_id;
	String artist;
	String title;
	int duration;
	URL url;
	int lyrics_id;
	int album_id;
	int genre_id;
	Date date;
	boolean no_search;
	
	public static final String defaultStr = "%%null%%";
	
	public static Audio constructAudioFromJSON(JSONObject json) {
		Audio audio = new Audio();
		try {
			audio.id = json.optInt("id", 0);
			audio.owner_id = json.optInt("owner_id", 0);
			audio.artist = json.optString("artist", defaultStr);
			audio.title = json.optString("title", defaultStr);
			audio.duration = json.optInt("duration", 0);
			audio.lyrics_id = json.optInt("lyrics_id", 0);
			audio.genre_id = json.optInt("genre_id", 0);
			audio.date = new Date(json.optLong("date", System.currentTimeMillis()));
			audio.url = json.has("url") ? new URL(json.optString("url")) : null;
		} catch (MalformedURLException ex) {
			//Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
		}
		return audio;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public URL getUrl() {
		return url;
	}

	public int getId() {
		return id;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public int getDuration() {
		return duration;
	}

	public int getDurationMM() {
		return duration / 60;
	}

	public int getDurationSS() {
		return duration - getDurationMM() * 60;
	}

	public int getLyrics_id() {
		return lyrics_id;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public Date getDate() {
		return date;
	}

	public boolean isNo_search() {
		return no_search;
	}

	@Override
	public ObjectType getType() {
		return ObjectType.Audio;
	}
	
}
