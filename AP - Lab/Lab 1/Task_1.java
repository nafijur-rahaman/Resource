https://www.notion.so/School-Management-Project-Api-Doc-28bca050b81880deaee5fb58dc388414

import java.util.Scanner;

public class Task_1 {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int length;
        System.out.println("Enter the Size of Array");
        length = input.nextInt();

        int arr[] = new int[length];

        for (int i = 0; i < length; i++) {

            arr[i] = input.nextInt();

        }

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < length; i++) {

            if (arr[i] % 2 == 0) {

                evenSum += arr[i];
            } else {

                oddSum += arr[i];
            }

        }

        System.out.println("Sum of even numbers" + " " + evenSum);
        System.out.println("Sum of odd numbers" + " " + oddSum);

    }
}

