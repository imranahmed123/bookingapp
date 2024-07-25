package com.bookingapp.notificationservice.controller;

import com.bookingapp.notificationservice.entity.Notification;
import com.bookingapp.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestParam Long userId,
                                                         @RequestParam String message,
                                                         @RequestParam(required = false) String phoneNumber,
                                                         @RequestParam(required = false) String email) {
        Notification notification = notificationService.sendNotification(userId, message, phoneNumber, email);
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }
}
