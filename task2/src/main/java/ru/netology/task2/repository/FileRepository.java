package ru.netology.task2.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileRepository {
    public void saveFile(String file_name, MultipartFile file) {
        try {
            Files.write(Path.of(file_name), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getFile(String file_name) {
        try {
            return Files.readAllBytes(Path.of(file_name));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
