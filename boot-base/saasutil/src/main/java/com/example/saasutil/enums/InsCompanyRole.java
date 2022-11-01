package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InsCompanyRole {
  //随机
  RANDOM(0),
  //轮询
  CYCLE(1);

  Integer role;
  InsCompanyRole(Integer role) {
    this.role = role;
  }
  Integer getRole() {
    return role;
  }

  public static InsCompanyRole getRole(String roleIn) {
    List<InsCompanyRole> values = Arrays.asList(InsCompanyRole.values());
    List<InsCompanyRole> types = values.stream()
        .filter(role -> role.name().equals(roleIn)).collect(Collectors.toList());
    return types.stream().findFirst().get();
  }

  public static void main(String[] args) {
    System.out.println(InsCompanyRole.getRole("RANDOM").name());
  }
}
