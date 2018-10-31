package com.blank.rest.controller;

import com.blank.rest.model.ItemCatResult;
import com.blank.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ItemCatController {

  @Autowired
  private ItemCatService itemCatService;

  @RequestMapping(value = "/itemCat/list")
  @ResponseBody
  public ItemCatResult getItemCats(){
    return itemCatService.getItemCats();
  }



}
