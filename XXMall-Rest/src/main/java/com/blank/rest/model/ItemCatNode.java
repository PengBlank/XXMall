package com.blank.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ItemCatNode {

  @JsonProperty("u")
  private String url;
  @JsonProperty("n")
  private String name;
  @JsonProperty("i")
  private List items;
}
