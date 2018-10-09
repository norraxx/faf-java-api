package com.faforever.api.data.checks.permission;

public class IsUserAdministrator {
  public static final String EXPRESSION = "IsUserAdministrator";

  public static class Inline extends BasePermission {
    public Inline() {
      super(IsUserAdministrator.EXPRESSION);
    }
  }
}
