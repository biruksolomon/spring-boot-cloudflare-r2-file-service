package com.Cloudflare.private_public_File_handler.Controller;

import com.Cloudflare.private_public_File_handler.Service.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {

    private final StorageService storage;

    public FileController(StorageService storage) {
        this.storage = storage;
    }

    @PostMapping("/public/upload")
    public String uploadPublic(@RequestParam MultipartFile file) throws Exception {
        storage.uploadPublic(file.getOriginalFilename(), file.getBytes());
        return "Public upload OK";
    }

    @PostMapping("/private/upload")
    public String uploadPrivate(@RequestParam MultipartFile file) throws Exception {
        storage.uploadPrivate(file.getOriginalFilename(), file.getBytes());
        return "Private upload OK";
    }

    @GetMapping("/private/{name}")
    public byte[] downloadPrivate(@PathVariable String name) {
        return storage.downloadPrivate(name);
    }
}
