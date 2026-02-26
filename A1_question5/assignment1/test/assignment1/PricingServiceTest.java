package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.Order;
import com.example.shop.OrderItem;
import com.example.shop.PricingService;

import static org.junit.jupiter.api.Assertions.*;

class PricingServiceTest {

    private final PricingService service = new PricingService();

    @Test
    void calculatesSubtotalCorrectly() {
        Order order = new Order();
        order.addItem(new OrderItem("A", 2, 5.0));
        order.addItem(new OrderItem("B", 1, 10.0));

        assertEquals(20.0, service.calculateSubtotal(order));
    }

    @Test
    void returnsZeroTaxForZeroSubtotal() {
        assertEquals(0.0, service.calculateTax(0));
    }

    @Test
    void calculatesTaxCorrectly() {
        assertEquals(20.0, service.calculateTax(100.0));
    }

    @Test
    void throwsExceptionForNegativeSubtotal() {
        assertThrows(IllegalArgumentException.class,
                () -> service.calculateTax(-1));
    }
}

