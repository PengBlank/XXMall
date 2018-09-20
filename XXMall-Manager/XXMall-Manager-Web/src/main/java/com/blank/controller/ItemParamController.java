package com.blank.controller;

import com.blank.service.TbItemParamService;
import com.blank.vo.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/item/param")
public class ItemParamController {

  @Autowired
  private TbItemParamService tbItemParamService;

  @RequestMapping("/list")
  @ResponseBody
  public EasyUIDataGridResult getParamList(Integer page, Integer rows) throws Exception {

    EasyUIDataGridResult dataGridResult = tbItemParamService.getItemParamList(page, rows);
    return dataGridResult;
  }
}
