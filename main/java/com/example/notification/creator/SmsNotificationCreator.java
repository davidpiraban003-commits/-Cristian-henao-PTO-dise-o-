package com.example.notification.creator;

import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;
import com.example.notification.model.SmsNotification;
import org.springframework.stereotype.Component;


@Component
public class SmsNotificationCreator extends NotificationCreator {

    @Override
    public Notification crearNotificacion() {
        return new SmsNotification();
    }

    @Override
    public NotificationType getTipoSoportado() {
        return NotificationType.SMS;
    }
}
