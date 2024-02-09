package com.elearning.serviceImpl;

import com.elearning.service.StorageService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class LocalStorageServiceImpl implements StorageService {

    @Value("${app.local.path}")
    private String localRootDir;




    @Override

    public String addVideoFile(MultipartFile file) {
        File rootDir = new File(localRootDir);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }

        String videoFile = file.getOriginalFilename();
        String filename = FilenameUtils.getBaseName(videoFile);

        // Générer un UUID
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        // Créer un nouveau nom de fichier avec l'UUID
        String newVideoFile = uuidString + "." + FilenameUtils.getExtension(videoFile);

        File serverFile = Paths.get(localRootDir, newVideoFile).toFile();
        try {
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            System.out.println("Échec de l'ajout de la vidéo!!");
        }
        return newVideoFile;
    }
    public String addCoursFile(MultipartFile file) {
        File rootDir = new File(localRootDir);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }

        String coursFile = file.getOriginalFilename();
        String filename = FilenameUtils.getBaseName(coursFile);

        // Générer un UUID
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();

        // Créer un nouveau nom de fichier avec l'UUID
        String newCoursFile = uuidString + "." + FilenameUtils.getExtension(coursFile);

        File serverFile = Paths.get(localRootDir, newCoursFile).toFile();
        try {
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            System.out.println("Échec de l'ajout de la vidéo!!");
        }
        return newCoursFile;
    }
    @Override
    public String addTpFile(MultipartFile file) {
        File rootDir = new File(localRootDir);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }
        String tpFile = file.getOriginalFilename();
        String filename = FilenameUtils.getBaseName(tpFile);
        // Générer un UUID
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        // Créer un nouveau nom de fichier avec l'UUID
        String newTpFile = uuidString + "." + FilenameUtils.getExtension(tpFile);
        File serverFile = Paths.get(localRootDir, newTpFile).toFile();
        try {
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            System.out.println("Échec de l'ajout de la tp!!");
        }
        return newTpFile;
    }
    public String addDocumentFile(MultipartFile file) {
        File rootDir = new File(localRootDir);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }
        String documentFile = file.getOriginalFilename();
        String filename = FilenameUtils.getBaseName(documentFile);
        // Générer un UUID
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        // Créer un nouveau nom de fichier avec l'UUID
        String newDocumentFile = uuidString + "." + FilenameUtils.getExtension(documentFile);
        File serverFile = Paths.get(localRootDir, newDocumentFile).toFile();
        try {
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            System.out.println("Échec de l'ajout du document!!");
        }
        return newDocumentFile;
    }
    public String addUserImage(MultipartFile file) {
        File rootDir = new File(localRootDir);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }
        String imgfile = file.getOriginalFilename();
        String filename = FilenameUtils.getBaseName(imgfile);
        // Générer un UUID
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        // Créer un nouveau nom de fichier avec l'UUID
        String newFileName = uuidString + "." + FilenameUtils.getExtension(imgfile);
        File serverFile = Paths.get(localRootDir, newFileName).toFile();
        try {
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
        } catch (Exception e) {
            System.out.println("Échec de l'ajout de l'image utilisateur!!");
        }
        return newFileName;
    }
    @Override
    public Path buildUserImagePath(String imgfile) {
        return Paths.get(localRootDir, imgfile);
    }
    @Override
    public Path buildTpFile(String tpFile) {
        return Paths.get(localRootDir, tpFile);
    }


    @Override
    public Path buildVideoFile(String videoFile) {
         return Paths.get(localRootDir, videoFile);
    }
    @Override
    public Path buildCoursFile(String coursFile) {
        return Paths.get(localRootDir, coursFile);
    }

    @Override
    public Path buildDocumentFile(String documentFile) {
        return Paths.get(localRootDir,documentFile);
    }
}
