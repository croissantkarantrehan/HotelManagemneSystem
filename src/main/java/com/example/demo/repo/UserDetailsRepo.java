package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserTable;

public interface UserDetailsRepo extends JpaRepository<UserTable, Long> {


	UserTable findByName(String user);

}
