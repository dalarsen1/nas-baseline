package org.mitre.tdp;

import java.util.function.Consumer;

public final class LibraryFunction implements Consumer<String> {

  @Override
  public void accept(String name) {
    System.out.println("Welcome to my Java Library " + name);
  }
}
