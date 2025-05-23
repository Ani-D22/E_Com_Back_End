package com.aniket.E_Com_Back_End.controller;


import com.aniket.E_Com_Back_End.model.Order;
import com.aniket.E_Com_Back_End.model.User;
import com.aniket.E_Com_Back_End.repo.UserRepo;
import com.aniket.E_Com_Back_End.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
class OrderController {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getallorders")
    public ResponseEntity<List<Order>> getOrders(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepo.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(orderService.getOrders(user));
    }

    @PostMapping("/placeorder")
    public ResponseEntity<Order> createOrder(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepo.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(orderService.createOrder(user));
    }

    @GetMapping("/orders/customer/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}
