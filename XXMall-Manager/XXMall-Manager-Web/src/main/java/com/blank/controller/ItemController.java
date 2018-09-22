package com.blank.controller;

import com.blank.pojo.TbItem;
import com.blank.service.TbItemService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class ItemController {

  @Autowired
  private TbItemService tbItemService;

  @RequestMapping(value = "/item/save",method = RequestMethod.POST)
  @ResponseBody
  public XXMallResult addItem(TbItem item, String desc){
    return tbItemService.addItem(item,desc);
  }

  //查询所有商品
  @RequestMapping(value = "/item")
  @ResponseBody
  public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    EasyUIDataGridResult result = tbItemService.getItemList(page, rows);
    return result;
  }



}
