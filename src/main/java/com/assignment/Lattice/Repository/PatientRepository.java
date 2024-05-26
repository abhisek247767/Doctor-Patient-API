package com.assignment.Lattice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.Lattice.Model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}