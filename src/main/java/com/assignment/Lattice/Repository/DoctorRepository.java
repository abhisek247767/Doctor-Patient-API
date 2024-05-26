package com.assignment.Lattice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.Lattice.Model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, String speciality);
}