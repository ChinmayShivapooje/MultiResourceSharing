package com.chinmay.Resource_Sharing.Repo;

import com.chinmay.Resource_Sharing.Entity.UploadEntity;
import com.chinmay.Resource_Sharing.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepo extends JpaRepository<UserEntity,Long> {

}
