package com.blank.vo;

public class XXMallResult {

  private int status;
  private String msg;
  private Object data;

  public XXMallResult (){
    this.status = 200;
    this.msg = "请求成功";
    this.data="";
  }

  public XXMallResult(int status, String msg){
    this.status = status;
    this.msg =msg;
  }

  public XXMallResult(int status, String msg, Object data){
    this.data = data;
    this.msg = msg;
    this.status = status;
  }

  public static XXMallResult success(){
    return  new XXMallResult();
  }

  public static XXMallResult error(int status, String msg){
    return new XXMallResult(status,msg);
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }


}
