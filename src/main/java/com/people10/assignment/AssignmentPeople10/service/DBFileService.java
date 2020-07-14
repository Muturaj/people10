package com.people10.assignment.AssignmentPeople10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.people10.assignment.AssignmentPeople10.DAO.DBfileInter;
import com.people10.assignment.AssignmentPeople10.model.DBFile;

@Service
public class DBFileService {

	@Autowired
	DBfileInter dbfilerepo;

	public DBFile storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			if (fileName.contains("..")) {
				throw new RuntimeException();

			}

			DBFile db = new DBFile(fileName, file.getContentType(), file.getBytes());
			return dbfilerepo.save(db);

		}

		catch (Exception e) {
		}
		return null;

	}

	public DBFile getFile(int fileId) {

		return dbfilerepo.findByFileId(fileId);

	}

}
