package com.polinaSattarova.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.polinaSattarova.client.PolinaSattarovaService;

public class PolinaSattarovaServiceImpl extends RemoteServiceServlet implements PolinaSattarovaService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}