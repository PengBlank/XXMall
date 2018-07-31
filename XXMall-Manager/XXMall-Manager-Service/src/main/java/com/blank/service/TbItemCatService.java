package com.blank.service;

import com.blank.vo.EasyUITreeNode;
import java.util.List;
import org.springframework.stereotype.Service;


public interface TbItemCatService {
  List<EasyUITreeNode> getTreeNode(long id);
}
