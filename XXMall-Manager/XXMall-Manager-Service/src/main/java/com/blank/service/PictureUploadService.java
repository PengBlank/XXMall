package com.blank.service;

import com.blank.pojo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureUploadService {
  PicUploadResult uploadPicture(MultipartFile uploadFile);
}
