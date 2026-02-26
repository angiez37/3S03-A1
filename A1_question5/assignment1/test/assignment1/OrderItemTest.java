package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void calculatesTotalPriceCorrectly() {
        OrderItem item = new OrderItem("Book", 2, 10.0);
        assertEquals(20.0, item.getTotalPrice());
    }

    @Test
    void throwsExceptionForZeroQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Book", 0, 10.0));
    }

    @Test
    void throwsExceptionForNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> new OrderItem("Book", 1, -5.0));
    }
}
