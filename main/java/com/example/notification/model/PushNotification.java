package com.example.notification.model;

public class PushNotification implements Notification {

    @Override
    public void enviar(String mensaje, String destinatario) {
        
        System.out.printf("[PUSH] Para dispositivo: %s | Mensaje: %s%n", destinatario, mensaje);
    }

    @Override
    public String getTipo() {
        return "PUSH";
    }
}
