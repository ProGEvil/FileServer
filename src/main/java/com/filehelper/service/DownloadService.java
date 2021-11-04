package com.filehelper.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@Service
public interface DownloadService {
    String downloadAndGetStatus(String id, HttpServletResponse response);
}
