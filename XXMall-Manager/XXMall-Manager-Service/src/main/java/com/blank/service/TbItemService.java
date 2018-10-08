package com.blank.service;

import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemDesc;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import java.util.List;


public interface TbItemService {

  EasyUIDataGridResult getItemList(Integer page, Integer rows);

  XXMallResult addItem(TbItem tbItem, String desc, String itemParams);

  XXMallResult getItemDesc(Integer id);

  XXMallResult delItem(List<Long> list);

  XXMallResult updateItem(TbItem tbItem, String desc);
}
