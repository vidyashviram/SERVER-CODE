package com.mro.drc.userroles.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mro.drc.userroles.entity.Roles;
import com.mro.drc.userroles.entity.Users;

/**
 * @author 20126160
 * Repository to perform CRUD operations on User table 
 *
 */
public interface UserManagementDao extends JpaRepository<Users, Integer> {

	// User Management Queries

	/**
	 * @return
	 * Fetch all the records from User table
	 */
	@Query("FROM Users")
	List<Users> getUserDetails();
	
	/**
	 * @param userId
	 * @return
	 * Fetch the user records of the given user Id
	 */
	@Query("FROM Users u where u.userId= :userId")
	Users getUserDataToEdit(@Param("userId") Integer userId);
	
	/**
	 * @return
	 * Fetch the records from Role table
	 */
	@Query("FROM Roles")
	List<Roles> getRoles();
	
	/**
	 * @param userId
	 * @param status
	 * @param date
	 * @return
	 * Update the status column value of the User table record for the given user Id
	 */
	@Modifying
	@Query(value="Update Users set active= :status, modifieddate= :date WHERE userId= :userId", nativeQuery = true)
    Integer deleteUserData(@Param("userId") Integer userId, @Param("status") boolean status, Date date);
}
