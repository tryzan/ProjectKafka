package com.unittestdemo.dao;

import com.unittestdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("""
            SELECT role
            FROM Role as role
            where role.name = :name
            """)
    Role findRoleByName(@Param("name") String name);
}
