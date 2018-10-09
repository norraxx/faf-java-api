package com.faforever.api.data.domain;

import com.faforever.api.data.checks.permission.IsUserAdministrator;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.ReadPermission;
import com.yahoo.elide.annotation.SharePermission;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "group_permission")
@Setter
@Include(rootLevel = true)
@ReadPermission(expression = IsUserAdministrator.EXPRESSION)
@SharePermission
public class GroupPermission extends AbstractEntity {
  private String name;
  private Set<GroupPermissionAssignment> assignments;

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  @OneToMany(mappedBy = "permission")
  public Set<GroupPermissionAssignment> getAssignments() {
    return assignments;
  }
}
