package com.assignment.Lattice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Lattice.Model.Doctor;
import com.assignment.Lattice.Model.Patient;
import com.assignment.Lattice.Service.HealthService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;

@RestController
@RequestMapping("/api1")

public class HealthController {

    @Autowired
    private HealthService healthService;

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = healthService.addDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        healthService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = healthService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        healthService.removePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/suggest-doctors/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        try {
            List<Doctor> doctors = healthService.suggestDoctors(patientId);
            return ResponseEntity.ok(doctors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}