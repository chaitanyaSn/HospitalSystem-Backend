package com.Hospital_Management.AppointmentMs.Service;


import com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail;
import com.Hospital_Management.AppointmentMs.Dto.AppointmentDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AppointmentProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentProducer.class);

    private final KafkaTemplate<String, AppointmentDetail> kafkaTemplate;

    private final String topicName;

    public AppointmentProducer(
            KafkaTemplate<String, AppointmentDetail> kafkaTemplate,
            @Value("${spring.kafka.topic.appointment}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendAppointmentScheduledEvent(AppointmentDetail appointmentDetail) {
        LOGGER.info("Publishing appointment event: {}", appointmentDetail);
        kafkaTemplate.send(topicName, appointmentDetail);
    }
}
