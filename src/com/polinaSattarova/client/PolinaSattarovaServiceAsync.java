package com.polinaSattarova.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PolinaSattarovaServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
