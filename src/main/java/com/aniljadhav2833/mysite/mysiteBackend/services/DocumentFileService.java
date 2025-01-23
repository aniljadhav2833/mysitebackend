package com.aniljadhav2833.mysite.mysiteBackend.services;

import com.aniljadhav2833.mysite.mysiteBackend.dto.DownloadFile;
import com.aniljadhav2833.mysite.mysiteBackend.model.DocumentFile;
import com.aniljadhav2833.mysite.mysiteBackend.repository.DocumentFileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class DocumentFileService {


    @Autowired
    DocumentFileRepo documentFileRepo;

    public DocumentFile uploadFile(MultipartFile file) throws IOException{
        DocumentFile documentFile = new DocumentFile();
        documentFile.setName(file.getOriginalFilename());
        documentFile.setData(file.getBytes());
        return documentFileRepo.save(documentFile);
    }

    public DownloadFile downloadFile(int id){
        DownloadFile file = new DownloadFile();
        Optional<DocumentFile> filebyId = documentFileRepo.findById(id);
        byte[] data = filebyId.map(DocumentFile::getData).orElse(null);
        String fileName = filebyId.get().getName();
        file.setData(data);
        file.setFileName(fileName);
        file.setFileType(mediaChecker(fileTypeChecker(fileName)));
        return file;
    }

    private String fileTypeChecker(String fileName){
        String[] name = fileName.split("\\.");
        String type = name[name.length-1];
        return type.toUpperCase();
    }

    private MediaType mediaChecker(String fileType){
        switch (fileType){
            case "JPEG":
            return MediaType.IMAGE_JPEG;
            case "PNG":
                return MediaType.IMAGE_PNG;
            default:
                return MediaType.APPLICATION_PDF;
        }
    }
}
