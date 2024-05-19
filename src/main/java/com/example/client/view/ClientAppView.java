package com.example.client.view;

import com.example.client.utils.Constants;

import java.util.Scanner;

public class ClientAppView {

    private final Scanner INPUT = new Scanner(System.in);

    public String getOption() {
        getMenu();
        return INPUT.next();
    }

    private void getMenu() {
        System.out.print("""

                OPTIONS:
                1 - Create contact.
                2 - Read contacts.
                3 - Update contact.
                4 - Delete contact.
                5 - Read contact by id.
                0 - Close the App.
                """);
        System.out.print("Input your option: ");
    }

    public void getOutput(String output) {
        if (output.equals("0")) {
            System.out.println(Constants.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }

}
