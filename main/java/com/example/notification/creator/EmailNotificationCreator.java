package com.example.notification.creator;

import com.example.notification.model.EmailNotification;
import com.example.notification.model.Notification;
import com.example.notification.model.NotificationType;
import org.springframework.stereotype.Component;


@Component
public class EmailNotificationCreator extends NotificationCreator {

    @Override
    public Notification crearNotificacion() {
        return new EmailNotification();
    }

    @Override
    public NotificationType getTipoSoportado() {
        return NotificationType.EMAIL;
    }
}
