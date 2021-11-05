package com.filehelper.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@Service
public interface DownloadService {
    String downloadAndGetStatus(String uuid, HttpServletResponse response);
}
