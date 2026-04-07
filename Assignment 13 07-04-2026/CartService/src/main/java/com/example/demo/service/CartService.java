package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Get all cart items for a user
    @CircuitBreaker(name = "cartService", fallbackMethod = "getCartFallback")
    public List<Cart> getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    // Add item to cart
    @CircuitBreaker(name = "cartService", fallbackMethod = "addToCartFallback")
    public Cart addToCart(Cart cart) {
        cart.setTotalPrice(cart.getPrice() * cart.getQuantity());
        return cartRepository.save(cart);
    }

    // Update cart item quantity
    @CircuitBreaker(name = "cartService", fallbackMethod = "updateCartFallback")
    public Cart updateCart(Long id, int quantity) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart item not found with id: " + id));
        cart.setQuantity(quantity);
        cart.setTotalPrice(cart.getPrice() * quantity);
        return cartRepository.save(cart);
    }

    // Remove single item from cart
    @CircuitBreaker(name = "cartService", fallbackMethod = "removeItemFallback")
    public String removeItem(Long id) {
        cartRepository.deleteById(id);
        return "Item removed from cart successfully";
    }

    // Clear entire cart for a user
    @CircuitBreaker(name = "cartService", fallbackMethod = "clearCartFallback")
    @Transactional
    public String clearCart(Long userId) {
        cartRepository.deleteByUserId(userId);
        return "Cart cleared successfully for user: " + userId;
    }

    // Get all carts (admin)
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // ==================== FALLBACK METHODS ====================

    public List<Cart> getCartFallback(Long userId, Exception ex) {
        System.out.println("CartService is down! Fallback triggered: " + ex.getMessage());
        return new ArrayList<>();
    }

    public Cart addToCartFallback(Cart cart, Exception ex) {
        System.out.println("CartService is down! Cannot add to cart: " + ex.getMessage());
        Cart fallbackCart = new Cart();
        fallbackCart.setProductName("Service Unavailable");
        return fallbackCart;
    }

    public Cart updateCartFallback(Long id, int quantity, Exception ex) {
        System.out.println("CartService is down! Cannot update cart: " + ex.getMessage());
        return new Cart();
    }

    public String removeItemFallback(Long id, Exception ex) {
        return "Cart service is currently unavailable. Please try again later.";
    }

    public String clearCartFallback(Long userId, Exception ex) {
        return "Cart service is currently unavailable. Please try again later.";
    }
}
