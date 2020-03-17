package com.mro.drc.userroles.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mro.drc.userroles.entity.Roles;

/**
 * @author 20126160
 * Repository class to perform CRUD operations on Role Table in SQL Database
 *
 */
public interface RoleManagementDao extends JpaRepository<Roles, Integer> {

	// User Management Queries

	/**
	 * @return
	 * Fetch all the details from role table
	 */
	@Query("FROM Roles")
	List<Roles> getRolesDetails();
	
	/**
	 * @param roleId
	 * @return
	 * Fetch the role details which matches the given roleId
	 */
	@Query("FROM Roles u where u.roleId= :roleId")
	List<Roles> getRoleDataToEdit(@Param("roleId") Integer roleId);
	
	/**
	 * @param roleId
	 * @param status
	 * @param date
	 * @return
	 * Update the status column value of the Role table record for the given role Id
	 */
	@Modifying
	@Query(value="Update Roles set active= :status, modifieddate= :date WHERE roleId= :roleId", nativeQuery = true)
    Integer deleteRoleData(@Param("roleId") Integer roleId, @Param("status") boolean status, Date date);
}
