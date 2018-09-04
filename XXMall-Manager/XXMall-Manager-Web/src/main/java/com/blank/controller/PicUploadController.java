package com.blank.controller;

import com.blank.pojo.PicUploadResult;
import com.blank.service.PictureUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PicUploadController {

  @Autowired
  private PictureUploadService pictureUploadService;
  @RequestMapping("/rest/pic/upload")
  @ResponseBody
  public PicUploadResult uploadImgFile(MultipartFile uploadFile){
      PicUploadResult result;
      result = pictureUploadService.uploadPicture(uploadFile);
      return result;
  }
}
