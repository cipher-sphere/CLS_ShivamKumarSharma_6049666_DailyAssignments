package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // GET all carts (admin use)
    @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    // GET cart items by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartByUser(@PathVariable Long userId) {
        List<Cart> cartItems = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartItems);
    }

    // POST add item to cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.addToCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    // PUT update quantity
    @PutMapping("/update/{id}")
    public ResponseEntity<Cart> updateCart(
            @PathVariable Long id,
            @RequestParam int quantity) {
        Cart updatedCart = cartService.updateCart(id, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    // DELETE single item
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeItem(@PathVariable Long id) {
        String message = cartService.removeItem(id);
        return ResponseEntity.ok(message);
    }

    // DELETE clear entire cart for user
    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        String message = cartService.clearCart(userId);
        return ResponseEntity.ok(message);
    }
}
