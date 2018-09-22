package com.blank.service;

import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;

public interface TbItemParamService {
      EasyUIDataGridResult getItemParamList(Integer page, Integer rows) throws Exception;
      XXMallResult queryExsitParam(long cid);
}
