package com.andy.learning.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_ROLE")
public class TRole implements Serializable {

  @Id
  private long id;
  private String role;
  private long userId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
