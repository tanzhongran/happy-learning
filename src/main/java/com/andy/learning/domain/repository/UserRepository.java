package com.andy.learning.domain.repository;

import com.andy.learning.domain.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TUser,Long> {

    public TUser findTUserByUsername(String username);

    public TUser findTUserById(long id);

}
