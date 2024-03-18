package br.com.bucker.domain.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.MappedSuperclass;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@RegisterForReflection
public abstract class Notifications implements BasicValidation {
    private List<Notification> notifications = new ArrayList<>();

    public void validating() {
        this.validate();
    }

    public void addNotification(String domain, String error) {
        this.notifications.add(Notification.builder()
                .domain(domain)
                .message(error)
                .build());
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void addNotifications(List<Notification> notifications) {
        this.notifications.addAll(notifications);
    }

    public Boolean isValid() {
        return this.notifications.isEmpty();
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public String errorMessage() {
        ObjectMapper mapper = new ObjectMapper();
        List<String> messages = new ArrayList<>();
        try {
            return mapper.writeValueAsString(this.notifications);
        } catch (JsonProcessingException e) {
            return "Error parsing notifications to JSON: %s".formatted(e.getMessage());
        }
    }
}
