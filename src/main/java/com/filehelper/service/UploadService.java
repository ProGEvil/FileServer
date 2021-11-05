package com.filehelper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {

    String uploadAndGetUuid(@RequestParam MultipartFile file);
}
