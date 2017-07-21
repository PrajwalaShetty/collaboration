package com.dao;

import com.model.ProfilePhoto;

public interface FileUploadDAO {
	void save(ProfilePhoto uploadFile);
	ProfilePhoto getFile(String username);
}
