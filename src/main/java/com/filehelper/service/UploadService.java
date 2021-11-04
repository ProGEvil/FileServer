package com.filehelper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {

    String uploadAndGetId(MultipartFile file);
}
