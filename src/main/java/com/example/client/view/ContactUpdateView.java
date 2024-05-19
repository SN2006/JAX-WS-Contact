package com.example.client.view;

import java.util.Scanner;

public class ContactUpdateView {

    private final Scanner INPUT = new Scanner(System.in);

    public String[] getData() {
        System.out.println("\nUPDATE FORM");
        String[] data = new String[3];
        System.out.print("Input id: ");
        data[0] = INPUT.nextLine().trim();
        System.out.print("Input name: ");
        data[1] = INPUT.nextLine().trim();
        System.out.print("Input phone in format xxx xxx-xxxx: ");
        data[2] = INPUT.nextLine().trim();
        return data;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
