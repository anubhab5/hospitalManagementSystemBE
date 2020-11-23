package com.amarhospital.svc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amarhospital.svc.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

}
