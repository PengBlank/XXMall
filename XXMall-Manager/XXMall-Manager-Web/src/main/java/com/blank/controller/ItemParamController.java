package com.blank.controller;

import com.blank.service.TbItemParamService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/item")
public class ItemParamController {

  @Autowired
  private TbItemParamService tbItemParamService;

  @RequestMapping(value = "/param/list", method = {RequestMethod.GET})
  @ResponseBody
  public EasyUIDataGridResult getParamList(Integer page, Integer rows) throws Exception {
    return tbItemParamService.getItemParamList(page, rows);
  }

  //判断模板是否存在(根据cid)
  @RequestMapping(value = "/param/{cid}", method = {RequestMethod.GET})
  @ResponseBody
  public XXMallResult queryExsitParam(@PathVariable Long cid) {
    return tbItemParamService.queryExsitParam(cid);
  }

  //新增模板参数
  @RequestMapping(value = "/param/{cid}", method = {RequestMethod.POST})
  @ResponseBody
  public XXMallResult addItemCatParam(@PathVariable Long cid, String paramData) {
    return tbItemParamService.addItemCatParam(cid, paramData);
  }

  //删除模板参数
  @RequestMapping(value = "/param/delete", method = {RequestMethod.POST})
  @ResponseBody
  public XXMallResult delItemCatParam(Long[] ids) {
    //Array To List
//    Long[] idsArray = params.getIds();
    List<Long> list = Arrays.asList(ids);
    //List to Array
    //List<Long> list = params.getIds();
    //Long[] ids = list.toArray(new Long[list.size()]);
    return tbItemParamService.delItemCatParam(list);
  }

  //编辑模板参数
  @RequestMapping(value = "/param/update", method = {RequestMethod.POST})
  @ResponseBody
  public XXMallResult updateItemCatParam(Long[] ids) {
    //Array To List
//    Long[] idsArray = params.getIds();
    List<Long> list = Arrays.asList(ids);
    //List to Array
    //List<Long> list = params.getIds();
    //Long[] ids = list.toArray(new Long[list.size()]);
    return tbItemParamService.updateItemCatParam(list);
  }


}