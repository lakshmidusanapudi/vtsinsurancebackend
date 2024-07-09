package com.learner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learner.entity.UserFeedBack;

@Repository
public interface UserFeedBackRepository  extends JpaRepository<UserFeedBack, Integer>{

}
