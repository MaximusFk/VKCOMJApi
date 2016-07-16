/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects.serialize;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import org.json.JSONObject;
import org.vklib.api.objects.Audio;
import org.vklib.api.objects.IVKObject;
import org.vklib.api.objects.serialize.SerializableItem;
import static org.vklib.api.objects.serialize.SerializableItem.ItemType.URL;

/**
 *
 * @author maximusfk
 */
public class SerializableItemFactory {
	
	public static <T extends IVKObject>  T createFromJSON(T emptyObject, JSONObject json) {
		for(Field f : emptyObject.getClass().getFields()) {
			if(f.isAnnotationPresent(SerializableItem.class)) {
				try {
					SerializableItem ann = f.getAnnotation(SerializableItem.class);
					String key = ann.key();
					if(!json.has(key))
						continue;
					switch(ann.type()) {
						case BOOL:
							f.setBoolean(emptyObject, (json.optInt(key, 0) != 0));
							break;
						case DATE:
							f.set(emptyObject, new Date(json.optLong(key, System.currentTimeMillis())));
							break;
						case FLOAT:
							break;
						case INT:
							f.setInt(emptyObject, json.optInt(key, 0));
							break;
						case STRING:
							f.set(emptyObject, json.optString(key, Audio.defaultStr));
							break;
						case URL:
							f.set(emptyObject, new URL(json.optString(key)));
							break;
					}
				} catch (IllegalArgumentException | IllegalAccessException | MalformedURLException ex) {
					System.out.print("\n" + ex);
				}
			}
		}
		return emptyObject;
	}
	
}
