package com.example.client.controller;

import com.example.client.service.ClientAppService;
import com.example.client.view.ClientAppView;

public class ClientAppController {

    ClientAppView view;
    ClientAppService service;

    public ClientAppController(ClientAppView view, ClientAppService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        service.handleOption(view.getOption());
    }
}
