package com.example.notification.creator;

import com.example.notification.model.NotificationType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class NotificationCreatorFactory {

    private final Map<NotificationType, NotificationCreator> creators;

    public NotificationCreatorFactory(List<NotificationCreator> creatorsDisponibles) {
        this.creators = creatorsDisponibles.stream()
                .collect(Collectors.toMap(
                        NotificationCreator::getTipoSoportado,
                        Function.identity()
                ));
    }

    public NotificationCreator obtenerCreator(NotificationType tipo) {
        NotificationCreator creator = creators.get(tipo);
        if (creator == null) {
            throw new IllegalArgumentException("No existe un Creator registrado para el tipo: " + tipo);
        }
        return creator;
    }
}
