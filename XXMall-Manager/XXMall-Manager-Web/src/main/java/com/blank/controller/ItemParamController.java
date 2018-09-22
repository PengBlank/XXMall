package com.blank.controller;

import com.blank.service.TbItemParamService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/item")
public class ItemParamController {

  @Autowired
  private TbItemParamService tbItemParamService;

  @RequestMapping("/param/list")
  @ResponseBody
  public EasyUIDataGridResult getParamList(Integer page, Integer rows) throws Exception {
    return tbItemParamService.getItemParamList(page, rows);
  }

  //判断模板是否存在(根据cid)
  @RequestMapping("/param/{cid}")
  @ResponseBody
  public XXMallResult queryExsitParam(@PathVariable long cid){
    return tbItemParamService.queryExsitParam(cid);
  }
}
