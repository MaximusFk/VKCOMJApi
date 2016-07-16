/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects;

import java.util.Date;
import org.vklib.api.ObjectType;
import org.vklib.api.objects.UserObjects.City;
import org.vklib.api.objects.UserObjects.Contacts;

/**
 *
 * @author MaximusFk
 */
public class User implements IVKObject {
    ///Main
    int ID;
    String firstName;
    String lastName;
    String deactivated;
    int hidden;
    
    //Additional
    
    Date bdate;
    boolean blacklisted;
    boolean blacklisted_by_me;
    String books;
    boolean can_post;
    boolean can_see_all_posts;
    boolean can_see_audio;
    boolean can_see_friends_request;
    boolean can_write_private_message;
    //Career career;
    City city;
    int common_count;
    //Unknow connections;
    Contacts contacs;
	//Counters counters;
	//Country country;
	UserPhoto userPhoto;
	TextInfo info;
	
	//Education education;
	int followers_count;
	//FriendStatus friend_status;
	
	boolean has_mobile;
	boolean has_photo;
	
	boolean is_favorite;
	boolean is_friend;
	boolean is_hidden_from_feed;
	//LastSeen last_seen;
	//Military military;
	
	//Occupation occupation;
	boolean online;
	boolean online_mobile;
	boolean online_app;
	//Personal personal;
	
	
	
	//ArrayList<Relatives> relatives;
	//Relation relation;
	//ArrayList<School> schools;
	String screen_name;
	Sex sex;
	String status;
	//Status_audio status_audio;
	int timezone;
	
	//ArrayList<University> universities;
	boolean verified;
	boolean wall_comments;
	
	public enum Sex {
		Male,
		Female,
		None
	}
	
	public enum FriendStatus {
		NotFriend,
		OutSubscription,
		InSubscription,
		Friend
	}
	
	private class TextInfo {
		String movies;
		String nickname;
		String lists;
		String maiden_name;
		String home_town;
		String interests;
		String games;
		String domain;
		String tv;
		String quotes;
		String about;
		String activities;
		String site;
	}
	private class UserPhoto {
		String photo_50;
		String photo_100;
		String photo_200_orig;
		String photo_200;
		String photo_400_orig;
		String photo_id;
		String photo_max_orig;
		String photo_max;
		Crop crop;
		Crop rect;
		Photo photo;
		
		class Crop {
			int x;
			int y;
			int x2;
			int y2;
		}
	}

	@Override
	public ObjectType getType() {
		return ObjectType.User;
	}
}
