package org.project.user.feature.cv;

import jakarta.servlet.http.HttpServletRequest;
import org.project.user.feature.cv.dto.CvRespone;
import org.project.user.feature.file.dto.FileResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvService {
    CvRespone uploadSingleFile(MultipartFile file, HttpServletRequest request);
    List<String> uploadMultipleFiles(MultipartFile[] files);

    ResponseEntity<Resource> serveFile(String filename, HttpServletRequest request);
    void deleteFile(String filename);
}
