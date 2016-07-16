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
public class Photo implements IVKObject {
	private int id;
	private int albumId;
	private int ownerId;
	private int userId;
	private String text;
	private Date date;
	private int width;
	private int height;
	
	private URL photo75;
	private URL photo130;
	private URL photo604;
	private URL photo807;
	private URL photo1280;
	private URL photo2560;
	
	private Photo() {
		
	}
	
	public static Photo constructPhotoFromJSON(JSONObject json) {
		Photo photo = new Photo();
		try {
			photo.id = json.optInt("id", 0);
			photo.albumId = json.optInt("album_id", 0);
			photo.ownerId = json.optInt("owner_id", 0);
			photo.userId = json.optInt("user_id", 0);
			photo.text = json.optString("text", Audio.defaultStr);
			photo.date = new Date(json.optLong("date", System.currentTimeMillis()));
			photo.photo75 = json.has("photo75") ? new URL(json.optString("photo75")) : null;
			photo.photo130 = json.has("photo130") ? new URL(json.optString("photo130")) : null;
			photo.photo604 = json.has("photo604") ? new URL(json.optString("photo604")) : null;
			photo.photo807 = json.has("photo807") ? new URL(json.optString("photo807")) : null;
			photo.photo1280 = json.has("photo1280") ? new URL(json.optString("photo1280")) : null;
			photo.photo2560 = json.has("photo2560") ? new URL(json.optString("photo2560")) : null;
		} catch (MalformedURLException ex) {
			//Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return photo;
	}

	public int getId() {
		return id;
	}

	public int getAlbumId() {
		return albumId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public int getUserId() {
		return userId;
	}

	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public URL getPhoto75() {
		return photo75;
	}

	public URL getPhoto130() {
		return photo130;
	}

	public URL getPhoto604() {
		return photo604;
	}

	public URL getPhoto807() {
		return photo807;
	}

	public URL getPhoto1280() {
		return photo1280;
	}

	public URL getPhoto2560() {
		return photo2560;
	}

	@Override
	public ObjectType getType() {
		return ObjectType.Photo;
	}
}
