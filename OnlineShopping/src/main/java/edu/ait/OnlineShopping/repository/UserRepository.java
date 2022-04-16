package edu.ait.OnlineShopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ait.OnlineShopping.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}