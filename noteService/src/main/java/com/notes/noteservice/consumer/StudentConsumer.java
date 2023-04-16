package com.notes.noteservice.consumer;

import com.notes.noteservice.service.NoteService;
import com.notes.noteservice.service.NoteServiceImpl;
import lombok.extern.slf4j.Slf4j;
import model.StudentResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentConsumer {


    private  NoteServiceImpl noteService;

    @Lazy
    public StudentConsumer(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }


    @KafkaListener(groupId = "kafka-group-id",
            topicPartitions = {@TopicPartition(topic = "student-topic",
                    partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0", relativeToCurrent = "true"))}
    )
    public void studentConsumer(StudentResponse studentResponse) {
        noteService.setStudentResponse(studentResponse);
    }

}