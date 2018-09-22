package com.blank.service.impl;

import com.blank.mapper.TbItemParamExMapper;
import com.blank.mapper.TbItemParamMapper;
import com.blank.pojo.TbItemParam;
import com.blank.pojo.TbItemParamExample;
import com.blank.pojo.TbItemParamExample.Criteria;
import com.blank.pojo.TbItemParamModel;
import com.blank.service.TbItemParamService;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.XXMallResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {


  @Autowired
  private TbItemParamExMapper tbItemParamExMapper;

  @Autowired
  private TbItemParamMapper tbItemParamMapper;

  @Override
  public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) throws Exception {
    //设置分页信息
    PageHelper.startPage(page, rows);
    //取数据
    List<TbItemParamModel> itemParamModels = tbItemParamExMapper.getItemParamList(page, rows);
    //取分页信息
    PageInfo<TbItemParamModel> pageInfo = new PageInfo<>(itemParamModels);
    //创建返回结果对象
    EasyUIDataGridResult result = new EasyUIDataGridResult();
    result.setTotal(pageInfo.getTotal());
    result.setRows(itemParamModels);
    return result;
  }

  @Override
  public XXMallResult queryExsitParam(long cid) {
    TbItemParamExample example = new TbItemParamExample();
    Criteria criteria = example.createCriteria();
    criteria.andItemCatIdEqualTo(cid);
    List<TbItemParam> list = tbItemParamMapper.selectByExample(example);
    if (list != null && list.size() > 0) {
      TbItemParam itemParam = list.get(0);
      return XXMallResult.success(itemParam);
    }
    return  XXMallResult.success();
  }

  @Override
  public XXMallResult addItemCatParam(long cid, String paramData) {
    TbItemParam itemParam = new TbItemParam();
    itemParam.setItemCatId(cid);
    itemParam.setParamData(paramData);
    itemParam.setCreated(new Date());
    itemParam.setUpdated(new Date());
    tbItemParamMapper.insert(itemParam);
    return XXMallResult.success();
  }

  @Override
  public XXMallResult delItemCatParam(List ids) {
    TbItemParamExample example = new TbItemParamExample();
    Criteria criteria = example.createCriteria();
    criteria.andIdIn(ids);
    tbItemParamMapper.deleteByExample(example);
    return XXMallResult.success();
  }

  @Override
  public XXMallResult updateItemCatParam(Long id) {
    TbItemParamExample example = new TbItemParamExample();
    Criteria criteria = example.createCriteria();
    criteria.andIdEqualTo(id);
    tbItemParamMapper.updateByExample(example);
    return XXMallResult.success();
  }
}
