package com.people10.assignment.AssignmentPeople10.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.people10.assignment.AssignmentPeople10.model.DBFile;

@Repository
public interface DBfileInter extends JpaRepository<DBFile, String> {

	DBFile findByFileId(int fileId);

}
