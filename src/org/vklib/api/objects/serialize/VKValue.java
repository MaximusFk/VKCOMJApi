/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects.serialize;

import java.net.URL;
import java.util.Date;
import org.vklib.api.objects.serialize.SerializableItem.ItemType;

/**
 *
 * @author maximusfk
 */
public class VKValue {
	Integer ivalue;
	Boolean bvalue;
	String svalue;
	URL uvalue;
	Date dvalue;
	
	String key;
	
	ItemType type;

	public VKValue(Integer ivalue, String key) {
		this.ivalue = ivalue;
		this.key = key;
		type = ItemType.INT;
	}

	public VKValue(Boolean bvalue, String key) {
		this.bvalue = bvalue;
		this.key = key;
		type = ItemType.BOOL;
	}

	public VKValue(String svalue, String key) {
		this.svalue = svalue;
		this.key = key;
		type = ItemType.STRING;
	}

	public VKValue(URL uvalue, String key) {
		this.uvalue = uvalue;
		this.key = key;
		type = ItemType.URL;
	}

	public VKValue(Date dvalue, String key) {
		this.dvalue = dvalue;
		this.key = key;
		type = ItemType.DATE;
	}
	
	public int getIntValue() {
		return ivalue;
	}
	
	public boolean getBooleanValue() {
		return bvalue;
	}
	
	public String getStringValue() {
		return svalue;
	}
	
	public Date getDateValue() {
		return dvalue;
	}
	
	public URL getURLValue() {
		return uvalue;
	}
	
	public String getKey() {
		return key;
	}
	
	public ItemType getType() {
		return type;
	}
}
