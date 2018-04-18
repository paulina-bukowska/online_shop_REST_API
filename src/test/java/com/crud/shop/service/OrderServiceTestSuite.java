package com.crud.shop.service;

import com.crud.shop.domain.Cart;
import com.crud.shop.domain.Order;
import com.crud.shop.domain.User;
import com.crud.shop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTestSuite {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserService userService;

    @Test
    public void shouldCreateOrder() {
        //Given
        User user = new User(3, "Veronica", "Smith", "Ivry", "ver@test.com", new ArrayList<>(), new ArrayList<>());
        Cart cart = new Cart(15, user, new ArrayList<>());
        Order testOrder = new Order(1, user, false);

        when(userService.getUser(user.getId())).thenReturn(user);
        when(orderRepository.save(testOrder)).thenReturn(testOrder);

        //When
        Order result = orderService.createOrder(user.getId());

        //Then
        assertEquals("1", result.getId());
        assertFalse(result.getConfirmation());
        assertEquals("Veronica", result.getUser().getFirstname());
    }
}