package com.evgenia.mywebapp.dao;

import com.evgenia.mywebapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
