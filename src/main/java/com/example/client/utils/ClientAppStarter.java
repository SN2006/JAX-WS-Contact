package com.example.client.utils;

import com.example.client.controller.ClientAppController;
import com.example.client.service.ClientAppService;
import com.example.client.view.ClientAppView;

public class ClientAppStarter {

    public static void startApp(){
        ClientAppService service = new ClientAppService();
        ClientAppView view = new ClientAppView();
        ClientAppController controller = new ClientAppController(view, service);
        controller.run();
    }

}
