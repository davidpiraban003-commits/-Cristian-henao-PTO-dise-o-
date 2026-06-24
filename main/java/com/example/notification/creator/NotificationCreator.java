package com.example.notification.creator;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;


 
public abstract class NotificationCreator {

   
    public abstract Notification crearNotificacion();

  
    public abstract NotificationType getTipoSoportado();

   
    public void procesarEnvio(String mensaje, String destinatario) {
        Notification notification = crearNotificacion();
        
        notification.enviar(mensaje, destinatario);
    }
}
