package com.pixelmind.materialgrid.controller;

import com.pixelmind.materialgrid.dto.CommonResponseDTO;
import com.pixelmind.materialgrid.model.Person;
import com.pixelmind.materialgrid.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/material-grid/bulk-upload")
public class BulkUploadController {

    private final PersonRepository personRepository;

    @PostMapping(value = "/trips-sheet")
    public ResponseEntity<CommonResponseDTO> uploadTripSheet(@RequestBody MultipartFile file) {

        try {
            // 10-second simulated processing delay / timeout
            TimeUnit.SECONDS.sleep(5);

            // TODO: Process file data here

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Optional<Person> byId = personRepository.findById(1);

        if (!byId.isPresent()) {

            return ResponseEntity.ok(
                    new CommonResponseDTO(
                            HttpStatus.BAD_REQUEST,
                            "Material Transport Trips Sheet Uploaded :: Customer Not Found",
                            null
                    )
            );

        }

        return ResponseEntity.ok(
                new CommonResponseDTO(
                        HttpStatus.OK,
                        "Material Transport Trips Sheet Uploaded " + byId.get().getFirstName() + " " + byId.get().getLastName(),
                        null
                )
        );

    }

    @PostMapping(value = "/daily-expenses")
    public ResponseEntity<CommonResponseDTO> uploadDailyExpenses(@RequestBody MultipartFile file) {

        try {
            // 10-second simulated processing delay / timeout
            TimeUnit.SECONDS.sleep(5);

            // TODO: Process file data here

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Optional<Person> byId = personRepository.findById(1);

        if (!byId.isPresent()) {

            return ResponseEntity.ok(
                    new CommonResponseDTO(
                            HttpStatus.BAD_REQUEST,
                            "Daily expenses Uploaded :: Customer Not Found",
                            null
                    )
            );

        }

        return ResponseEntity.ok(
                new CommonResponseDTO(
                        HttpStatus.OK,
                        "Daily expenses Uploaded " + byId.get().getFirstName() + " " + byId.get().getLastName(),
                        null
                )
        );
    }

}
