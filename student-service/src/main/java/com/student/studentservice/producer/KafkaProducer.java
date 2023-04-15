package com.student.studentservice.producer;

import model.StudentResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void studentProducer(StudentResponse studentResponse) {
        kafkaTemplate.send("student-topic", 0, "key-1", studentResponse);
    }





}
