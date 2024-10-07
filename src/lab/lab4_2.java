package lab;

import java.util.Random;
import java.util.Scanner;

public class lab4_2
{
    // tap : psvm
    public static void main(String[] args)
    {
        String value = "cardtreesavefishloadtest";
        Random random = new Random();
        String password = "";
        int num1 = random.nextInt(1000, 10000);
        password += num1;
        int num2 = random.nextInt(0, 6);
        password += value.substring(num2 * 4, num2 * 4 + 4);
        int num3 = random.nextInt(1000, num1);
        password += num3;
        System.out.println(password);
    }


}

