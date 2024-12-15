package com.aniket.E_Com_Back_End.repo;

import com.aniket.E_Com_Back_End.model.Order;
import com.aniket.E_Com_Back_End.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}

