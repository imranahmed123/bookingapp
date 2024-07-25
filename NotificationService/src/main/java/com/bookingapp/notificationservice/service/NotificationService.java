package com.bookingapp.notificationservice.service;

import com.bookingapp.notificationservice.entity.Notification;
import com.bookingapp.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private SnsClient snsClient;

    @Transactional
    public Notification sendNotification(Long userId, String message, String phoneNumber, String email) {
        // Send SMS Notification
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            PublishRequest smsRequest = PublishRequest.builder()
                    .message(message)
                    .phoneNumber(phoneNumber)
                    .build();
            snsClient.publish(smsRequest);
        }

        // Send Email Notification
        if (email != null && !email.isEmpty()) {
            PublishRequest emailRequest = PublishRequest.builder()
                    .message(message)
                    .subject("Booking Confirmation")
                    .topicArn(email)
                    .build();
            snsClient.publish(emailRequest);
        }

        // Save notification information in the database
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setNotificationTime(LocalDateTime.now());
        notification.setStatus("SENT");

        return notificationRepository.save(notification);
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }
}
