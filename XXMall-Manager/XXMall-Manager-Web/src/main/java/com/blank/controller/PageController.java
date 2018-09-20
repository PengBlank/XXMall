package com.blank.controller;

import com.blank.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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




}
