package com.example.notification.controller;

import com.example.notification.model.NotificationType;
import com.example.notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/{tipo}")
    public String enviar(
            @PathVariable NotificationType tipo,
            @RequestParam String mensaje,
            @RequestParam String destinatario) {

        notificationService.enviarNotificacion(tipo, mensaje, destinatario);
        return "Notificación de tipo " + tipo + " enviada correctamente a " + destinatario;
    }
}
