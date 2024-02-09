package com.elearning.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {

    String addUserImage(MultipartFile file);
    String addVideoFile(MultipartFile file);

    String addDocumentFile(MultipartFile file);

    String addCoursFile(MultipartFile file);

    String addTpFile(MultipartFile file);

    Path buildUserImagePath(String imgfile);
    Path buildTpFile(String tpFile);


    Path buildVideoFile(String videoFile);



    Path buildCoursFile(String coursFile);

    Path buildDocumentFile(String documentFile);
}
