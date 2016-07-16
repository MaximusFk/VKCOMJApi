/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects;

import java.util.Date;
import org.json.JSONObject;
import org.vklib.api.ObjectType;

/**
 *
 * @author maximusfk
 */
public class Post implements IVKObject {
	int id;
	int ownerId;
	int fromId;
	Date date;
	String text;
	int replyOwnerId;
	int replyPostId;
	boolean friendsOnly;
	int signerId;
	boolean canPin;
	boolean canDelete;
	boolean canEdit;
	boolean isPinned;
	
	Comment comments;
	Like likes;
	Repost reposts;
	PostType posttype;
	Attachments attachments;
        
        private Post() {
            
        }
        
        public static Post constructPostFromJSON(JSONObject json) {
            Post post = new Post();
            post.id = json.optInt("id");
            post.ownerId = json.optInt("owner_id");
            post.fromId = json.optInt("from_id");
            post.date = new Date(json.optLong("date", System.currentTimeMillis()));
            post.text = json.optString("text");
            post.replyOwnerId = json.optInt("reply_owner_id");
            post.replyPostId = json.optInt("reply_post_id");
            post.friendsOnly = json.optInt("friends_only") != 0;
            post.signerId = json.optInt("signer_id");
            post.canPin = json.optInt("can_pin") != 0;
            post.canEdit = json.optInt("can_edit") != 0;
            post.canDelete = json.optInt("can_delete") != 0;
            post.isPinned = json.optInt("is_pinned") != 0;
			if(json.has("comments")) {
				Comment comments = new Comment();
				JSONObject comm = json.getJSONObject("comments");
				comments.count = comm.optInt("count");
				comments.canPost = comm.optInt("can_post") != 0;
				post.comments = comments;
			}
			if(json.has("likes")) {
				Like likes = new Like();
				JSONObject lik = json.getJSONObject("likes");
				likes.count = lik.optInt("count");
				likes.canLike = lik.optInt("can_like") != 0;
				likes.canPublish = lik.optInt("can_publish") != 0;
				likes.userLikes = lik.optInt("user_likes") != 0;
				post.likes = likes;
			}
			if(json.has("reposts")) {
				Repost reposts = new Repost();
				JSONObject rep = json.getJSONObject("reposts");
				reposts.count = rep.optInt("count");
				reposts.userReposted = rep.optInt("user_reposted") != 0;
				post.reposts = reposts;
			}
            return post;
        }
	
	static class Comment {
		int count;
		boolean canPost;
	}
	
	static class Like {
		int count;
		boolean userLikes;
		boolean canLike;
		boolean canPublish;
	}
	
	static class Repost {
		int count;
		boolean userReposted;
	}
	
	enum PostType {
		Post,
		Copy,
		Reply,
		Postpone,
		Suggest
	}

	@Override
	public ObjectType getType() {
		return ObjectType.Post;
	}
}
