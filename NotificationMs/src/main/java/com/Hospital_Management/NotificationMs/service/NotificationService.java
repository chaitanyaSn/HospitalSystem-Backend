package com.Hospital_Management.NotificationMs.service;

import com.Hospital_Management.NotificationMs.Client.ProfileClient;
import com.Hospital_Management.NotificationMs.dto.AppointmentDto;
import com.Hospital_Management.NotificationMs.dto.DoctorDto;
import com.Hospital_Management.NotificationMs.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ProfileClient profileClient;

    @KafkaListener(topics = "${spring.kafka.topic.appointment}", groupId = "notification_group")
    public void consumeAppointmentEvent(AppointmentDto appointmentDto) {
        System.out.println("Received appointment event: " + appointmentDto);


        PatientDto patient = profileClient.getPatientById(appointmentDto.getPatientId());
        DoctorDto doctor = profileClient.getDoctorById(appointmentDto.getDoctorId());

        if (patient != null && patient.getEmail() != null) {
            sendPatientNotification(patient, doctor, appointmentDto);
        }

        // Send notification to doctor
        if (doctor != null && doctor.getEmail() != null) {
            sendDoctorNotification(doctor, patient, appointmentDto);
        }
    }

    private void sendPatientNotification(PatientDto patient, DoctorDto doctor, AppointmentDto appointmentDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(patient.getEmail());
        message.setSubject("Appointment Scheduled");
        message.setText(
                "Dear " + patient.getName() + ",\n\n" +
                        "Your appointment with Dr. " + doctor.getName() + " is scheduled for "
                        + appointmentDto.getAppointmentTime() + ".\nReason: " + appointmentDto.getReason() +
                        "\n\nThank you!"
        );
        mailSender.send(message);
        System.out.println(
                "Notification sent to patient: " + patient.getEmail() + " for appointment at " + appointmentDto.getAppointmentTime()
        );
    }

    private void sendDoctorNotification(DoctorDto doctor, PatientDto patient, AppointmentDto appointmentDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(doctor.getEmail());
        message.setSubject("New Appointment Scheduled");
        message.setText(
                "Dear Dr. " + doctor.getName() + ",\n\n" +
                        "A new appointment with patient " + patient.getName() + " is scheduled for "
                        + appointmentDto.getAppointmentTime() + ".\nReason: " + appointmentDto.getReason() +
                        "\n\nThank you!"
        );
        mailSender.send(message);
        System.out.println(
                "Notification sent to doctor: " + doctor.getEmail() + " for appointment at " + appointmentDto.getAppointmentTime()
        );
    }
}
