package com.example.notification.model;


public interface Notification {

   
    void enviar(String mensaje, String destinatario);

    
    String getTipo();
}
