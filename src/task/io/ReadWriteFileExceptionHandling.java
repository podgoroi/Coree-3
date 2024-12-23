package task.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class ReadWriteFileExceptionHandling {

  public static void createAndWriteFile(String fileName, String content) {
    try {
      FileWriter writer = new FileWriter(fileName);
      writer.write(content);
      writer.close();
    } catch (IOException e) {
      System.out.println("Ошибка");
      e.printStackTrace();
    }
  }

  public static void createFileFromConsoleInput() {
    Scanner scanner = new Scanner(System.in);
    String fileName = scanner.nextLine();
    String content = scanner.nextLine();
    try {
      FileWriter writer = new FileWriter(fileName);
      writer.write(content);
      writer.close();
    } catch (IOException e) {
      System.out.println("Ошибка");
      e.printStackTrace();
    }
  }

  public static double divideNumbers(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Число равно нулю");
    }
    return a / b;
  }

  public static void readNumberAndPrintSquare() {
    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    System.out.println(count * 2);
  }

  public static void readFileAndPrint(String fileName) {
    try {
      FileReader reader = new FileReader(fileName);
      int character;
      while ((character = reader.read()) != -1) {
        System.out.println((char) character);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Ошибка");
    }
  }

  public static int convertStringToNumber(String str) {
    return Integer.parseInt(str);
  }

  public static void divideConsoleInput() {
    Scanner scanner = new Scanner(System.in);
    int value1 = scanner.nextInt();
    int value2 = scanner.nextInt();
    if (value2 == 0) {
      throw new ArithmeticException("Число равно нулю");
    }
    System.out.println(value1 / value2);
  }

  public static void createFileAndReadFirstWord(String fileName, String content) {
    FileWriter writer = null;
    try {
      writer = new FileWriter(fileName);
      for (int i = 0; i < content.length(); i++) {
        writer.write(content.charAt(i));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        writer.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    FileReader reader = null;
    String str = "";
    try {
      reader = new FileReader(fileName);
      int character;
      while ((character=reader.read()) != -1) {
        str = str + (char)character;

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        reader.close();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    String [] st = str.split(" ");
    System.out.println(st[0]);
  }

  public static void main (String[]args){
    createFileFromConsoleInput();
    readNumberAndPrintSquare();
    divideConsoleInput();
    createFileAndReadFirstWord("test.txt", "Hello world");
  }
}