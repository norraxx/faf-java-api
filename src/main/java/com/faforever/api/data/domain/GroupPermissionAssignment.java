package com.faforever.api.data.domain;

import com.faforever.api.data.checks.permission.IsUserAdministrator;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.ReadPermission;
import com.yahoo.elide.annotation.SharePermission;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "group_permission_assignment")
@Setter
@Include
@ReadPermission(expression = IsUserAdministrator.EXPRESSION)
@SharePermission
public class GroupPermissionAssignment extends AbstractEntity {
  private UserGroup group;
  private GroupPermission permission;

  @ManyToOne
  @JoinColumn(name = "group_id")
  public UserGroup getGroup() {
    return group;
  }

  @ManyToOne
  @JoinColumn(name = "permission_id")
  public GroupPermission getPermission() {
    return permission;
  }
}
