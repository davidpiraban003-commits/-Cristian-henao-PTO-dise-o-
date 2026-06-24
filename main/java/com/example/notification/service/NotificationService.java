package com.example.notification.service;

import com.example.notification.creator.NotificationCreator;
import com.example.notification.creator.NotificationCreatorFactory;
import com.example.notification.model.NotificationType;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    private final NotificationCreatorFactory creatorFactory;

    public NotificationService(NotificationCreatorFactory creatorFactory) {
        this.creatorFactory = creatorFactory;
    }

    public void enviarNotificacion(NotificationType tipo, String mensaje, String destinatario) {
        NotificationCreator creator = creatorFactory.obtenerCreator(tipo);
        creator.procesarEnvio(mensaje, destinatario);
    }
}
