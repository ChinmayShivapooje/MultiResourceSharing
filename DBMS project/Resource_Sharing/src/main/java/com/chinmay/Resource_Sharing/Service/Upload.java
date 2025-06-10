package com.chinmay.Resource_Sharing.Service;

import com.chinmay.Resource_Sharing.Entity.UploadEntity;
import com.chinmay.Resource_Sharing.Repo.UploadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Upload {
    @Autowired
UploadRepo repo;
    public void uploaddata(UploadEntity u) {

        repo.save(u);
    }

    public List<UploadEntity> getAllData() {

      return   repo.findAll();
    }


    public UploadEntity getFileById(Long id) {
     return    repo.getReferenceById(id);
    }
}
