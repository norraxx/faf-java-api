package com.faforever.api.data.domain;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.ReadPermission;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "login")
@Setter
@Include(type = "user")
public class User extends Login {
  private String password;
  private Set<UserGroupAssignment> groupAssignments;

  @Column(name = "password")
  @ReadPermission(expression = "Prefab.Role.None")
  public String getPassword() {
    return password;
  }

  @OneToMany(mappedBy = "user")
  @ReadPermission(expression = "Prefab.Role.None")
  public Set<UserGroupAssignment> getGroupAssignments() {
    return groupAssignments;
  }
}
