package com.chinmay.Resource_Sharing.Service;

import com.chinmay.Resource_Sharing.Entity.UserEntity;
import com.chinmay.Resource_Sharing.Repo.UseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UseRepo repo;
    public void addUser(UserEntity u) {
        repo.save(u);

    }

    public List<UserEntity> getAllDbData() {
      return   repo.findAll();
    }
}
