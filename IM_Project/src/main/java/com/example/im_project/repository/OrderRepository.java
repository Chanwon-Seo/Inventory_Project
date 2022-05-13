package com.example.im_project.repository;

import com.example.im_project.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Delivery,Long> {
}
