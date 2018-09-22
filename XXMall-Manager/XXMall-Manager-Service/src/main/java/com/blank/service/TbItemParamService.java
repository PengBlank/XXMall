package com.blank.service;

import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import java.util.List;

public interface TbItemParamService {
      EasyUIDataGridResult getItemParamList(Integer page, Integer rows) throws Exception;
      XXMallResult queryExsitParam(long cid);
      XXMallResult addItemCatParam(long cid,String paramData);
      XXMallResult delItemCatParam(List ids);
      XXMallResult updateItemCatParam(List ids);
}
