package com.blank.controller;

import com.blank.service.TbItemService;
import com.blank.vo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

  @Autowired
  private TbItemService tbItemService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showIndex() {
    return "index";
  }

  @RequestMapping(value = "/rest/page/{path}")
  public String showPage(@PathVariable String path) {
    return path;
  }

  //查询所有商品
  @RequestMapping(value = "/rest/item")
  @ResponseBody
  public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    EasyUIDataGridResult result = tbItemService.getItemList(page, rows);
    return result;
  }


}
