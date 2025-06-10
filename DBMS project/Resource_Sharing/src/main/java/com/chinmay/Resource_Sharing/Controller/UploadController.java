package com.chinmay.Resource_Sharing.Controller;

import com.chinmay.Resource_Sharing.Entity.UploadEntity;
import com.chinmay.Resource_Sharing.Service.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    Upload service;

    // Uploading the file
    @PostMapping("/add")
    public ResponseEntity<String> upload(@RequestPart UploadEntity u, @RequestPart MultipartFile m) {
        try {
            // Set the file from the MultipartFile to the UploadEntity object
            u.setFile(m.getBytes());
            u.setFileType(m.getContentType()); // Store the content type (MIME type)

            service.uploaddata(u);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }

    // Downloading the file
    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) {
        UploadEntity fileEntity = service.getFileById(id);
        if (fileEntity == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayResource resource = new ByteArrayResource(fileEntity.getFile());

        // Get the file extension from fileType
        String fileType = fileEntity.getFileType();
        String extension = "";
        if (fileType != null) {
            if (fileType.contains("pdf")) {
                extension = ".pdf";
            } else if (fileType.contains("word")) {
                extension = ".docx";
            } else if (fileType.contains("excel")) {
                extension = ".xlsx";
            }
            // Add more conditions here for other file types if necessary
        }

        // Default to ".txt" if no valid file type is found
        if (extension.isEmpty()) {
            extension = ".txt";
        }

        // Append the correct extension to the filename
        String fileName = fileEntity.getName() + extension;

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.parseMediaType(fileType != null ? fileType : "application/octet-stream"))
                .contentLength(fileEntity.getFile().length)
                .body(resource);
    }
}
