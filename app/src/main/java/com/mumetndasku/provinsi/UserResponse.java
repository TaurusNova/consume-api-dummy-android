package com.mumetndasku.provinsi;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

	@SerializedName("users")
	private ArrayList<UserItem> users;

	public void setUsers(ArrayList<UserItem> users){
		this.users = users;
	}

	public List<UserItem> getUsers(){
		return users;
	}
}