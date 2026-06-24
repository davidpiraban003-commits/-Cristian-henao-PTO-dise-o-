package com.example.notification.model;


public class EmailNotification implements Notification {

    @Override
    public void enviar(String mensaje, String destinatario) {
        
        System.out.printf("[EMAIL] Para: %s | Mensaje: %s%n", destinatario, mensaje);
    }

    @Override
    public String getTipo() {
        return "EMAIL";
    }
}
