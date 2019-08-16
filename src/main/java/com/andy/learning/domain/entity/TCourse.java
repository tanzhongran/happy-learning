package com.andy.learning.domain.entity;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "T_COURSE")
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert @DynamicUpdate
public class TCourse {
  @Id
  private long id;
  private String supCode;
  private String courseName;
  private long capacity;
  private String isActive;
  private String isPersonalTraining;
  private String status;
  @CreatedDate
  private java.sql.Timestamp createTime;
  @LastModifiedDate
  private java.sql.Timestamp updateTime;


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


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }


  public String getIsActive() {
    return isActive;
  }

  public void setIsActive(String isActive) {
    this.isActive = isActive;
  }


  public String getIsPersonalTraining() {
    return isPersonalTraining;
  }

  public void setIsPersonalTraining(String isPersonalTraining) {
    this.isPersonalTraining = isPersonalTraining;
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


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
