package com.blank.service;

import com.blank.vo.EasyUIDataGridResult;


public interface TbItemService {
  EasyUIDataGridResult getItemList(Integer page, Integer rows);

}
