package com.blank.service.impl;

import com.blank.pojo.PicUploadResult;
import com.blank.service.PictureUploadService;
import com.blank.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureUploadServiceImpl implements PictureUploadService {


  @Value("${IMG_SERVER_ADDR_DEV}")
  private String imgServer;

  @Override
  public PicUploadResult uploadPicture(MultipartFile uploadFile) {
    PicUploadResult result = new PicUploadResult();
    if (uploadFile == null){
      result.setError(1);
      result.setMessage("上传失败，图片为空!");
      result.setUrl("");
    }
    try {
      FastDFSClient fastDFSClient = new FastDFSClient("classpath:properties/fdfs_client.conf");
      //取得图片名字
      String originName = uploadFile.getOriginalFilename();
      //取得图片后缀名
      String extName = originName.substring(originName.lastIndexOf(".") + 1);
      //取得返回的URL（不包含ip）
      String groupUrl = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
      String url = imgServer + "/" + groupUrl;//若不加http，前端回去本地服务器找

      result.setError(0);
      result.setUrl(url);
      result.setMessage("图片上传成功");
    } catch (Exception e) {
      result.setError(1);
      result.setMessage("获取图片服务器信息失败!");
      result.setUrl("");
      e.printStackTrace();
    }
    return result;
  }
}
