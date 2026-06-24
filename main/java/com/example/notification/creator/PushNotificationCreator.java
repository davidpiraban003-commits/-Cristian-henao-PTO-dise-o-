package com.example.notification.creator;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;
import com.example.notification.model.PushNotification;
import org.springframework.stereotype.Component;


 
@Component
public class PushNotificationCreator extends NotificationCreator {

    @Override
    public Notification crearNotificacion() {
        return new PushNotification();
    }

    @Override
    public NotificationType getTipoSoportado() {
        return NotificationType.PUSH;
    }
}
