package com.bushra.app.rest.Repo;

import com.bushra.app.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
