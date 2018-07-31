package com.blank.service.impl;

import com.blank.mapper.TbItemCatMapper;
import com.blank.pojo.TbItemCat;
import com.blank.pojo.TbItemCatExample;
import com.blank.pojo.TbItemCatExample.Criteria;
import com.blank.service.TbItemCatService;
import com.blank.vo.EasyUITreeNode;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {

  @Autowired
  private TbItemCatMapper tbItemCatMapper;

  @Override
  public List<EasyUITreeNode> getTreeNode(long parentId) {

    List<TbItemCat> itemCats = new ArrayList<>();
    TbItemCatExample example = new TbItemCatExample();
    Criteria criteria = example.createCriteria();
    criteria.andParentIdEqualTo(parentId);
    itemCats =  tbItemCatMapper.selectByExample(example);
    List<EasyUITreeNode> treeNodes = new ArrayList<>();
    for (TbItemCat itemCat : itemCats){
      EasyUITreeNode treeNode = new EasyUITreeNode();
      treeNode.setId(itemCat.getId());
      treeNode.setState(itemCat.getIsParent() ? "closed" : "open");
      treeNode.setText(itemCat.getName());
      treeNodes.add(treeNode);
    }
    return treeNodes;
  }

}
