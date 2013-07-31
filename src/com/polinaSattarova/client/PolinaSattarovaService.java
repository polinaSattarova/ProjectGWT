package com.polinaSattarova.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PolinaSattarovaService")
public interface PolinaSattarovaService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use PolinaSattarovaService.App.getInstance() to access static instance of MySampleApplicationServiceAsync
     */
    public static class App {
        private static PolinaSattarovaServiceAsync ourInstance = GWT.create(PolinaSattarovaService.class);

        public static synchronized PolinaSattarovaServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
