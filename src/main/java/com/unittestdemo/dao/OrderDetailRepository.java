package com.unittestdemo.dao;

import com.unittestdemo.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long> {
}
