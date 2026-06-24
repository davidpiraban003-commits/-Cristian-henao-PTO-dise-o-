package com.example.notification.model;


public class SmsNotification implements Notification {

    @Override
    public void enviar(String mensaje, String destinatario) {
        
        System.out.printf("[SMS] Para: %s | Mensaje: %s%n", destinatario, mensaje);
    }

    @Override
    public String getTipo() {
        return "SMS";
    }
}
