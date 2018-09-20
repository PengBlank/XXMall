package com.blank.service.impl;

import com.blank.mapper.TbItemParamExMapper;
import com.blank.mapper.TbItemParamMapper;
import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemExample;
import com.blank.pojo.TbItemParam;
import com.blank.pojo.TbItemParamExample;
import com.blank.pojo.TbItemParamModel;
import com.blank.service.TbItemParamService;
import com.blank.vo.EasyUIDataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {


  @Autowired
  private TbItemParamExMapper tbItemParamExMapper;

  @Override
  public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) throws Exception{
    //设置分页信息
    PageHelper.startPage(page,rows);
    //取数据
    List<TbItemParamModel> itemParamModels = tbItemParamExMapper.getItemParamList(page,rows);
    //取分页信息
    PageInfo<TbItemParamModel> pageInfo = new PageInfo<>(itemParamModels);
    //创建返回结果对象
    EasyUIDataGridResult result = new EasyUIDataGridResult();
    result.setTotal(pageInfo.getTotal());
    result.setRows(itemParamModels);
    return result;
  }
}