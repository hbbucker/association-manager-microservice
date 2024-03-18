package br.com.bucker.domain.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.MappedSuperclass;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@RegisterForReflection
public abstract class Notifications implements BasicValidation {
    private final List<Notification> notificationsMessages = new ArrayList<>();

    public void addNotification(String domain, String error) {
        this.notificationsMessages.add(Notification.builder()
                .domain(domain)
                .message(error)
                .build());
    }

    public void addNotification(Notification notification) {
        this.notificationsMessages.add(notification);
    }

    public void addNotifications(List<Notification> notifications) {
        this.notificationsMessages.addAll(notifications);
    }

    public boolean isValid() {
        return this.notificationsMessages.isEmpty();
    }

    public List<Notification> getNotifications() {
        return this.notificationsMessages;
    }

    public String errorMessage() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this.notificationsMessages);
        } catch (JsonProcessingException e) {
            return "Error parsing notifications to JSON: %s".formatted(e.getMessage());
        }
    }
}
