package com.example.client.view;

import java.util.Scanner;

public class ContactDeleteView {

    private final Scanner INPUT = new Scanner(System.in);

    public String[] getData() {
        System.out.println("\nDELETE FORM");
        String[] data = new String[1];
        System.out.print("Input id: ");
        data[0] = INPUT.nextLine().trim();
        return data;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
