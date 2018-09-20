package com.blank.mapper;

import com.blank.pojo.TbItemParamModel;
import java.util.List;

public interface TbItemParamExMapper {
  List<TbItemParamModel> getItemParamList(Integer page, Integer rows);
}
