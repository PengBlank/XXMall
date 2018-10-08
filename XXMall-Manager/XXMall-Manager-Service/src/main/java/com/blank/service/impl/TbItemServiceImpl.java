package com.blank.service.impl;

import static com.blank.vo.XXMallResult.success;

import com.blank.mapper.TbItemDescMapper;
import com.blank.mapper.TbItemMapper;
import com.blank.mapper.TbItemParamItemMapper;
import com.blank.pojo.TbItem;
import com.blank.pojo.TbItemDesc;
import com.blank.pojo.TbItemDescExample;
import com.blank.pojo.TbItemExample;
import com.blank.pojo.TbItemExample.Criteria;
import com.blank.pojo.TbItemParamItem;
import com.blank.service.TbItemService;
import com.blank.utils.UUIDGenerator;
import com.blank.vo.EasyUIDataGridResult;
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
  @Autowired
  private TbItemParamItemMapper tbItemParamItemMapper;

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
  public XXMallResult addItem(TbItem tbItem, String desc, String itemParams) {

    Date date = new Date();
    System.out.println("***************************");
    System.out.println("UUID is : " + UUIDGenerator.genItemId());
    System.out.println("***************************");
    tbItem.setId(UUIDGenerator.genItemId());
    tbItem.setCreated(date);
    tbItem.setUpdated(date);
    // '商品状态，1-正常，2-下架，3-删除'
    tbItem.setStatus((byte) 1);

    //insert into item_Desc 商品描述表
    TbItemDesc tbItemDesc = new TbItemDesc();
    tbItemDesc.setItemId(tbItem.getId());
    tbItemDesc.setItemDesc(desc);
    tbItemDesc.setCreated(date);
    tbItemDesc.setUpdated(date);

    tbItemMapper.insert(tbItem);
    tbItemDescMapper.insert(tbItemDesc);

    //商品规格model
    TbItemParamItem tbItemParamItem = new TbItemParamItem();
    tbItemParamItem.setCreated(date);
    tbItemParamItem.setUpdated(date);
    tbItemParamItem.setItemId(tbItem.getId());
    tbItemParamItem.setParamData(itemParams);

    tbItemParamItemMapper.insert(tbItemParamItem);

    XXMallResult result = success();//为什么只有成功的，若执行失败了怎么处理？

    return result;
  }

  @Override
  public XXMallResult getItemDesc(Integer id) {
    TbItemDesc tbItemDesc = null;
    TbItemDescExample example = new TbItemDescExample();
    List<TbItemDesc> list = tbItemDescMapper.selectByExample(example);
    if (list != null && list.size() > 0) {
      tbItemDesc = list.get(0);
    }
    return success(tbItemDesc);
  }

  @Override
  public XXMallResult delItem(List<Long> list) {
    TbItemExample example = new TbItemExample();
    Criteria criteria = example.createCriteria();
    criteria.andIdIn(list);
    tbItemMapper.deleteByExample(example);
    return success();
  }

  @Override
  public XXMallResult updateItem(TbItem tbItem, String desc) {
    TbItemExample itemExample = new TbItemExample();
    TbItemDescExample itemDescExample = new TbItemDescExample();

    TbItemDesc itemDesc = new TbItemDesc();
    itemDesc.setUpdated(new Date());
    itemDesc.setCreated(new Date());
    itemDesc.setItemDesc(desc);
    itemDesc.setItemId(tbItem.getId());

    tbItemMapper.updateByExample(tbItem,itemExample);
    tbItemDescMapper.updateByExample(itemDesc,itemDescExample);

    return XXMallResult.success();
  }
}
