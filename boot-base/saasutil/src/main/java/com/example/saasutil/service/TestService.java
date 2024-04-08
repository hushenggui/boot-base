package com.example.saasutil.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-02-23 16:44
 **/
public class TestService {


  public static void main(String[] args) {
   /* List<String> keys = Arrays.asList("a", "p", "R", "f");
    Collections.sort(keys, new CaseInsensitiveComparator());
    System.out.println(keys);*/
    long a = 43 / 10;
    if(43 / 10 != 0) {
      a++;
    }
    System.out.println(a);
  }


  private static class CaseInsensitiveComparator
      implements Comparator<String>, java.io.Serializable {
    // use serialVersionUID from JDK 1.2.2 for interoperability
    private static final long serialVersionUID = 8575799808933029326L;
    public int compare(String s1, String s2) {
      int n1 = s1.length();
      int n2 = s2.length();
      int min = Math.min(n1, n2);
      for (int i = 0; i < min; i++) {
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(i);
          if (c1 != c2) {
            if (c1 != c2) {
              return c1 - c2;
            }
        }
      }
      return n1 - n2;
    }
  }

}
