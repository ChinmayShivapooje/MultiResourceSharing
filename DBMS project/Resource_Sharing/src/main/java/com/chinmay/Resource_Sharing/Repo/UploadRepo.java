package com.chinmay.Resource_Sharing.Repo;

import com.chinmay.Resource_Sharing.Entity.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepo extends JpaRepository<
         UploadEntity,Long> {

}
