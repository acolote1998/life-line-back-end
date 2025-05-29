package com.akiacevedo.life_line_back_end.repository;

import com.akiacevedo.life_line_back_end.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, String> {
}
