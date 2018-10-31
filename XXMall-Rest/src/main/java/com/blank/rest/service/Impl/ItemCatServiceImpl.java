package com.blank.rest.service.Impl;

import com.blank.mapper.TbItemCatMapper;
import com.blank.pojo.TbItemCat;
import com.blank.pojo.TbItemCatExample;
import com.blank.pojo.TbItemCatExample.Criteria;
import com.blank.rest.model.ItemCatNode;
import com.blank.rest.model.ItemCatResult;
import com.blank.rest.service.ItemCatService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ItemCatServiceImpl implements ItemCatService {

  @Autowired
  private TbItemCatMapper tbItemCatMapper;

  @Override
  public ItemCatResult getItemCats() {
      ItemCatResult itemCatResult= new ItemCatResult();
      List itemCats = getItemCats(0);
      itemCatResult.setData(itemCats);
      return itemCatResult;
  }

  private List getItemCats(long parentId){
    TbItemCatExample tbItemCatExample = new TbItemCatExample();
    Criteria criteria = tbItemCatExample.createCriteria();
    criteria.andParentIdEqualTo(parentId);
    List<TbItemCat> itemCats =  tbItemCatMapper.selectByExample(tbItemCatExample);

    List itemCatNodes = new ArrayList<>();

    for (TbItemCat itemCat : itemCats){
      ItemCatNode itemCatNode = new ItemCatNode();
      if (itemCat.getIsParent()) {//如果是父节点
        itemCatNode.setUrl("/products/" + itemCat.getId() + ".html");
        if (itemCat.getParentId() == 0) {//如果是第一层
          itemCatNode.setName(
              "<a href='/products/" + itemCat.getId() + ".html'" + itemCat.getName() + "</a>");
        }else {
          itemCat.setName(itemCat.getName());
        }
        itemCatNode.setItems(getItemCats(itemCat.getId()));
        itemCatNodes.add(itemCatNode);
      }else{//如果是叶子节点
        String contents =  "/products/" + itemCat.getId() + ".html|" + itemCat.getName();
        itemCatNodes.add(contents);
      }
    }
    return  itemCatNodes;
  }
}
