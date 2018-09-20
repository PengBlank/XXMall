package com.blank.service.impl;

import com.blank.mapper.TbItemDescMapper;
import com.blank.mapper.TbItemMapper;
import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemDesc;
import com.blank.pojo.TbItemExample;
import com.blank.service.TbItemService;
import com.blank.utils.UUIDGenerator;
import com.blank.vo.EasyUIDataGridResult;
import com.blank.vo.EasyUITreeNode;
import com.blank.vo.XXMallResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TbItemServiceImpl implements TbItemService {

  @Autowired
  private TbItemMapper tbItemMapper;
  @Autowired
  private TbItemDescMapper tbItemDescMapper;

  @Override
  public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
    //设置分页
    PageHelper.startPage(page, rows);
    TbItemExample example = new TbItemExample();
    List<TbItem> list = tbItemMapper.selectByExample(example);
    PageInfo<TbItem> pageInfo = new PageInfo(list);
    EasyUIDataGridResult result = new EasyUIDataGridResult();
    result.setRows(list);
    result.setTotal(pageInfo.getTotal());
    return result;
  }

  @Override
  public XXMallResult addItem(TbItem tbItem, String desc) {

    Date createDate = new Date();
    Date updateDate = new Date();
    System.out.println("***************************");
    System.out.println("UUID is : "+UUIDGenerator.genItemId());
    System.out.println("***************************");
    tbItem.setId(UUIDGenerator.genItemId());
    tbItem.setCreated(createDate);
    tbItem.setUpdated(updateDate);
    // '商品状态，1-正常，2-下架，3-删除'
    tbItem.setStatus((byte) 1);

    //insert into item_Desc 商品描述表
    TbItemDesc tbItemDesc = new TbItemDesc();
    tbItemDesc.setItemId(tbItem.getId());
    tbItemDesc.setItemDesc(desc);
    tbItemDesc.setCreated(createDate);
    tbItemDesc.setUpdated(updateDate);

    tbItemMapper.insert(tbItem);
    tbItemDescMapper.insert(tbItemDesc);

    XXMallResult result = XXMallResult.success();//为什么只有成功的，若执行失败了怎么处理？

    return result;
  }
}
