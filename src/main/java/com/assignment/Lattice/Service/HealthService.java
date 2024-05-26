package com.assignment.Lattice.Service;

import java.util.List;
import java.util.Optional;

import com.assignment.Lattice.Model.Doctor;
import com.assignment.Lattice.Model.Patient;

public interface HealthService {

    Doctor addDoctor(Doctor doctor);

    void removeDoctor(Long id);

    Patient addPatient(Patient patient);

    void removePatient(Long id);

    List<Doctor> suggestDoctors(Long patientId);

    Optional<Patient> findPatientById(Long patientId);
}