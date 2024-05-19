package com.example.client.view;

import java.util.Scanner;

public class ContactReadByIdView {

    private final Scanner INPUT = new Scanner(System.in);

    public String[] getData() {
        System.out.println("\nREAD BY ID FORM");
        String[] data = new String[1];
        System.out.print("Input id: ");
        data[0] = INPUT.nextLine().trim();
        return data;
    }

    public void getOutput(String output) {
        System.out.println("\nDATA BY ID:\n" + output);
    }

}
