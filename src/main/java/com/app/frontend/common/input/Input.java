package com.app.frontend.common.input;

import java.util.Scanner;

public class Input {
  Scanner scanner;

  public Input() {
    this.scanner = new Scanner(System.in);
  }

  public String readString(String message) {
    String input;

    System.out.print(message);
    input = scanner.nextLine();

    return input;
  }

  public int readInt(String message) {
    int input;

    try {
      input = Integer.parseInt(readString(message));
    } catch (NumberFormatException e) {
      input = -1;
    }

    return input;
  }
}
