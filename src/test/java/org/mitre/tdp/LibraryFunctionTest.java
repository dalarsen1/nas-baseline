package org.mitre.tdp;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class LibraryFunctionTest {

  @Test
  void testLibraryFunction() {
    assertDoesNotThrow(() -> new LibraryFunction().accept("YourName"));
  }
}
