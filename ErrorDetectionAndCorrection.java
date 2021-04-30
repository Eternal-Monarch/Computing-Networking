
/**
 * wap in java to take input a character (A to Z, a to z, 0 to 9) from user
 * which will be the data to be transfered. define the following methods for
 * performing specific task 
 * i. convertbinary() - this is method is used to convert the ASCII value of the character into binary
 * ii. doerror() - this method is used to impose an error in the binary string
 * iii. addparity() - this method is used to concat or add parity bit at the end of original binary
 * iv. checkerror() - this method is used to check error
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ErrorDetectionAndCorrection {

  private static int getErrorIndex() {
    System.out.print("Enter the index to impose error on: ");
    Scanner sc = new Scanner(System.in);
    int index = Integer.parseInt(sc.nextLine());
    sc.close();
    return index;
  }

  private static int countNumberOfOnes(String message) {
    char[] chars = message.toCharArray();
    int numOfOnes = 0;
    for (char c : chars) {
      if (c == ' ')
        continue;
      if (c == '1')
        numOfOnes++;
    }
    return numOfOnes;
  }

  private static String convertBinary(String message) {
    String s = new String();
    char[] chars = message.toCharArray();
    for (char c : chars) {
      s += String.format("%8s", Integer.toBinaryString(c)).replace(" ", "0") + " ";
    }
    return s.trim();
  }

  private static String addParity(String messageInBinary, String parityType) {
    System.out.println(messageInBinary);
    int numOfOnes = countNumberOfOnes(messageInBinary);
    String parityBit = "0";
    if (numOfOnes % 2 == 0 && parityType == "odd") {
      parityBit = "1";
    }
    return messageInBinary + parityBit;
  }

  private static String doError(String messageWithParity) {
    int errorIdx = getErrorIndex();
    if (errorIdx == -1) {
      return messageWithParity;
    }
    StringBuilder sb = new StringBuilder(messageWithParity);
    sb.setCharAt(errorIdx, messageWithParity.charAt(errorIdx) == '1' ? '0' : '1');
    return new String(sb.toString());
  }

  private static void checkError(String message, String parityType) {
    int numOfOnes = countNumberOfOnes(message);

    if (numOfOnes % 2 == 0 && parityType == "odd") {
      System.out.println("Error detected.");
    }

    System.out.print("Message recieved: " + Arrays.stream(message.substring(0, message.length() - 1).split(" "))
        .map(binary -> Integer.parseInt(binary, 2)).map(Character::toString).collect(Collectors.joining()));

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter message: ");
    String message = scanner.nextLine();
    System.out.println("Message sent: " + message);
    message = convertBinary(message);
    message = addParity(message, "odd");
    message = doError(message);
    checkError(message, "odd");
    scanner.close();
  }
}

