package com.blank.controller;

import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemDesc;
import com.blank.service.TbItemService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class ItemController {

  @Autowired
  private TbItemService tbItemService;

  //新增商品
  @RequestMapping(value = "/item/save",method = RequestMethod.POST)
  @ResponseBody
  public XXMallResult addItem(TbItem item, String desc, String itemParams){
    return tbItemService.addItem(item,desc,itemParams);
  }

  //查询所有商品
  @RequestMapping(value = "/item")
  @ResponseBody
  public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    EasyUIDataGridResult result = tbItemService.getItemList(page, rows);
    return result;
  }

  //查询对应商品的描述
  @RequestMapping(value = "/item/desc")
  @ResponseBody
  public XXMallResult getItemDesc(Integer id) {
    return tbItemService.getItemDesc(id);
  }

  //删除商品
  @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
  @ResponseBody
  public XXMallResult delItem(Long[] ids){
    List<Long> idList = Arrays.asList(ids);
    return tbItemService.delItem(idList);
  }

  //编辑商品
  @RequestMapping(value = "/item", method = RequestMethod.PUT)
  @ResponseBody
  public XXMallResult updateItem(TbItem item, String desc){
    return tbItemService.updateItem(item, desc);
  }


}
