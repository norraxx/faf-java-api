package com.faforever.api.data.domain;

import com.faforever.api.data.checks.permission.HiddenGroupFilter;
import com.faforever.api.data.checks.permission.IsUserAdministrator;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.ReadPermission;
import com.yahoo.elide.annotation.SharePermission;
import com.yahoo.elide.annotation.UpdatePermission;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static com.faforever.api.data.checks.permission.Op.OR;

@Entity
@Table(name = "user_group")
@Setter
@Include(rootLevel = true)
@ReadPermission(expression = IsUserAdministrator.EXPRESSION + OR + HiddenGroupFilter.EXPRESSION)
@UpdatePermission(expression = IsUserAdministrator.EXPRESSION)
@SharePermission
public class UserGroup extends AbstractEntity {
  private String name;
  private Boolean publicGroup;
  private UserGroup parent;
  private Set<UserGroupAssignment> userGroupAssignments;
  private Set<GroupPermissionAssignment> permissionAssignments;

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @Column(name = "public", nullable = false)
  public Boolean getPublicGroup() {
    return publicGroup;
  }

  @ManyToOne
  @JoinColumn(name = "parent_group_id")
  public UserGroup getParent() {
    return parent;
  }

  @OneToMany(mappedBy = "group")
  public Set<UserGroupAssignment> getUserGroupAssignments() {
    return userGroupAssignments;
  }

  @OneToMany(mappedBy = "group")
  public Set<GroupPermissionAssignment> getPermissionAssignments() {
    return permissionAssignments;
  }
}
