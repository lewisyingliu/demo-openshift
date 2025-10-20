package com.example.demo.config;

import com.example.demo.entity.Election;
import com.example.demo.repo.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class ElectionController {

    private final ElectionRepository electionRepository;

    @GetMapping("/elections")
    public ResponseEntity<List<Election>> getAllElections() {
        try {
            List<Election> elections = electionRepository.findAll();
            if (elections.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(elections, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
