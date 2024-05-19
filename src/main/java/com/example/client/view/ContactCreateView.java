package com.example.client.view;

import java.util.Scanner;

public class ContactCreateView {

    private final Scanner INPUT = new Scanner(System.in);

    public String[] getData() {
        System.out.println("\nCREATE FORM");
        String[] data = new String[2];
        System.out.print("Input name: ");
        data[0] = INPUT.nextLine().trim();
        System.out.print("Input phone in format xxx xxx-xxxx: ");
        data[1] = INPUT.nextLine().trim();
        return data;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
