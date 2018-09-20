package com.blank.service;

import com.blank.pojo.TbItem;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;


public interface TbItemService {
  EasyUIDataGridResult getItemList(Integer page, Integer rows);
  XXMallResult  addItem(TbItem tbItem, String desc);
}
