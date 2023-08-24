package com.app.SocialMediaApp.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SocialMediaApp.domain.User;
import com.app.SocialMediaApp.repository.UserRepo;
import com.app.SocialMediaApp.domain.Post;
import com.app.SocialMediaApp.repository.PostRepo;

@Service
public class UserService {
	@Autowired
	public UserRepo repo;

	@Autowired
	public PostRepo postRepo;
	
	public User addUser(User user){
		return repo.save(user);
	}
	
	public void addFriend(long id,long friendId) {
		User user = repo.findById(id).get();
		User friend = repo.findById(friendId).get();
		
		List<User> userFriendList = user.getFriendList();
		userFriendList.add(repo.getOne(friendId));
		user.setFriendList(userFriendList);
		repo.save(user);
		
		List<User> otherFriendList = friend.getFriendList();
		otherFriendList.add(repo.getOne(id));
		friend.setFriendList(otherFriendList);
		repo.save(friend);
	}

	public boolean removeFriend(long id, long friendId) {
		User user = repo.findById(id).get();
		User removeUser = repo.getOne(friendId);
		List<User> friendList = user.getFriendList();
		List<User> otherFriendList = removeUser.getFriendList();
		
		if (!friendList.contains(removeUser)) return false;
		
		if (friendList.contains(removeUser)) {
			friendList.remove(repo.getOne(friendId));
			user.setFriendList(friendList);
			repo.save(user);
		}

		if (otherFriendList.contains(user)) {
			otherFriendList.remove(repo.getOne(id));
			removeUser.setFriendList(otherFriendList);
			repo.save(removeUser);
		}
		
		return true;
	}
	
	public List<User> getFriendList(long id) {
		Optional<User> u = repo.findById(id);
		if(u.isPresent()){
			List<User> friendList = u.get().getFriendList();
			return friendList;
		}
		return null;
	}

	public void addPost(long id, Post post) {
		User user = repo.findById(id).get();
		user.addPost(post);
		postRepo.save(post);
	}

	public void deletePost(long userId, long postId) {
		User user = repo.findById(userId).get();
		Post post = postRepo.findById(postId).get();
		user.removePost(post);
		postRepo.deleteById(postId);
	}
}
