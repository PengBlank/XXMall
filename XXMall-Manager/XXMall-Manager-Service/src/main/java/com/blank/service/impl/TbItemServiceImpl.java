package com.blank.service.impl;

import com.blank.mapper.TbItemMapper;
import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemExample;
import com.blank.service.TbItemService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.EasyUITreeNode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TbItemServiceImpl implements TbItemService {

  @Autowired
  private TbItemMapper tbItemMapper;

  @Override
  public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    //设置分页
    PageHelper.startPage(page, rows);
    TbItemExample example = new TbItemExample();
    List<TbItem> list = tbItemMapper.selectByExample(example);
    PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
    EasyUIDataGridResult result = new EasyUIDataGridResult();
    result.setRows(list);
    result.setTotal(pageInfo.getTotal());
    return result;
  }
}
