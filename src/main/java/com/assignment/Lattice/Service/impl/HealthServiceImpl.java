package com.assignment.Lattice.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Lattice.Model.Doctor;
import com.assignment.Lattice.Model.Patient;
import com.assignment.Lattice.Repository.DoctorRepository;
import com.assignment.Lattice.Repository.PatientRepository;
import com.assignment.Lattice.Service.HealthService;

@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void removeDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Doctor> suggestDoctors(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (!patientOpt.isPresent()) {
            throw new IllegalArgumentException("Patient not found");
        }

        Patient patient = patientOpt.get();
        String city = patient.getCity();
        String symptom = patient.getSymptom();

        String speciality;
        switch (symptom) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                speciality = "Orthopedic";
                break;
            case "Dysmenorrhea":
                speciality = "Gynecology";
                break;
            case "Skin infection":
            case "Skin burn":
                speciality = "Dermatology";
                break;
            case "Ear pain":
                speciality = "ENT specialist";
                break;
            default:
                throw new IllegalArgumentException("Unknown symptom");
        }

        if (!List.of("Delhi", "Noida", "Faridabad").contains(city)) {
            throw new IllegalArgumentException("We are still waiting to expand to your location");
        }

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(city, speciality);
        if (doctors.isEmpty()) {
            throw new IllegalArgumentException("There isn’t any doctor present at your location for your symptom");
        }

        return doctors;
    }

    @Override
    public Optional<Patient> findPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }

}
