package com.blank.controller;

import com.blank.service.TbItemCatService;
import com.blank.vo.EasyUITreeNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/item/cat")
public class ItemCatController {

  @Autowired
  private TbItemCatService tbItemCatService;

  //获取商品列表
  @RequestMapping(value = "/list",method = RequestMethod.POST)
  @ResponseBody
  public List<EasyUITreeNode> getItemCat(@RequestParam(value = "id",defaultValue = "0") long parentId) {
    List<EasyUITreeNode> treeNodes = tbItemCatService.getTreeNode(parentId);
    return treeNodes;
  }


}
