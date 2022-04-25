package ru.netology.task2.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.netology.task2.service.FileService;

@RestController
@RequestMapping()
public class FileController {
    private final FileService service;

    public FileController(FileService service) { this.service = service; }

    @PostMapping(value="/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveFile(@RequestParam("filename") String fileName, @RequestParam("content") MultipartFile file) {
        service.saveFile(fileName, file);
    }

    @GetMapping(value="/getFile", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] getFile(@RequestParam("filename") String fileName) {
        return service.getFile(fileName);
    }
}