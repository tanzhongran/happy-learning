
package com.andy.learning.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COURSE")
public class TCourse {

  @Id
  private long id;
  private String supCode;
  private String courseName;
  private String enableTag;

  private String remark;
  private String status;
  private java.sql.Timestamp createTime;
  private long createBy;
  private java.sql.Timestamp updateTime;
  private long updateBy;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSupCode() {
    return supCode;
  }

  public void setSupCode(String supCode) {
    this.supCode = supCode;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getEnableTag() {
    return enableTag;
  }

  public void setEnableTag(String enableTag) {
    this.enableTag = enableTag;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(long createBy) {
    this.createBy = createBy;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public long getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(long updateBy) {
    this.updateBy = updateBy;
  }

}
