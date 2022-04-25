package ru.netology.task2.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileRepository {
    public void saveFile(String fileName, MultipartFile file) {
        try {
            Files.write(Path.of(fileName), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getFile(String fileName) {
        try {
            return Files.readAllBytes(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
