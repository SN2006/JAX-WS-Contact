package com.example.client.service;

import com.example.client.controller.ContactController;
import com.example.client.exceptions.OptionException;
import com.example.client.utils.ClientAppStarter;
import com.example.client.utils.Constants;
import com.example.client.view.ClientAppView;

public class ClientAppService {

    ContactController controller = new ContactController();

    public void handleOption(String option) {
        switch (option) {
            case "1" -> controller.create();
            case "2" -> controller.read();
            case "3" -> controller.update();
            case "4" -> controller.delete();
            case "5" -> controller.readById();
            case "0" -> new ClientAppView().getOutput("0");
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_OPTION_MSG);
                } catch (OptionException e) {
                    new ClientAppView().getOutput(e.getMessage());
                    ClientAppStarter.startApp();
                }
            }
        }
    }
}
