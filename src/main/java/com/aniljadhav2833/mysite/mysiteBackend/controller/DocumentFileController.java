package com.aniljadhav2833.mysite.mysiteBackend.controller;

import com.aniljadhav2833.mysite.mysiteBackend.dto.DownloadFile;
import com.aniljadhav2833.mysite.mysiteBackend.services.DocumentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin()
public class DocumentFileController {

    @Autowired
    private DocumentFileService documentFileService;


    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile file){

        try {
            documentFileService.uploadFile(file);
            return "File uploaded successfully!";
        }catch (Exception e){
            return "File upload failed: " + e.getMessage();
        }
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable int id){
        DownloadFile downloadFile =
                documentFileService.downloadFile(id);
        if(downloadFile.getData() == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"filename=\""+downloadFile.getFileName()+"\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(downloadFile.getData());
    }

}
