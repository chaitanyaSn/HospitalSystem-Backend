package com.Hospital_Management.NotificationMs.service;

import com.Hospital_Management.NotificationMs.dto.AppointmentDetail;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EmailService emailService;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private final AtomicInteger messageCount = new AtomicInteger(0);


    @KafkaListener(topics = "${spring.kafka.topic.appointment}", groupId = "notification_group")
    public void consumeNotification(AppointmentDetail appointmentDetail){

        int currentCount = messageCount.incrementAndGet();

        // Log message received
        LOGGER.info("🔔 KAFKA MESSAGE #{} RECEIVED - Processing appointment notification", currentCount);
        LOGGER.info("📋 Appointment Details:");
        LOGGER.info("   └─ ID: {}", appointmentDetail.getId());
        LOGGER.info("   └─ Patient: {} ({})", appointmentDetail.getPatientName(), appointmentDetail.getPatientEmail());
        LOGGER.info("   └─ Doctor: {}", appointmentDetail.getDoctorName());
        LOGGER.info("   └─ Time: {}", appointmentDetail.getAppointmentTime());
        LOGGER.info("   └─ Reason: {}", appointmentDetail.getReason());

        try {
            LOGGER.info("📧 Preparing email notification for appointment ID: {}", appointmentDetail.getId());
            String body = "Hi " + appointmentDetail.getPatientName() + ",<br><br>"
                    + "Your appointment has been successfully scheduled.<br><br>"
                    + "Here are the details:<br>"
                    + "<b>Doctor:</b> " + appointmentDetail.getDoctorName() + "<br>"
                    + "<b>Date & Time:</b> " + appointmentDetail.getAppointmentTime() + "<br>"
                    + "<b>Reason:</b> " + appointmentDetail.getReason() + "<br><br>"
                    + "Please make sure to be available on time. If you need to reschedule or cancel, please visit your appointments page.<br><br>"
                    + "<br><br>Best regards,<br>Your Healthcare Team";

            emailService.sendEmail(appointmentDetail.getPatientEmail(), "Appointment Confirmation", body);
            LOGGER.info("Email sent successfully for appointment ID: {}", appointmentDetail.getId());

        } catch (Exception e) {
            LOGGER.error("Failed to process appointment notification for ID {}: {}",
                    appointmentDetail.getId(), e.getMessage(), e);
            // Consider implementing retry logic or dead-letter queue
        }
 }


}
