package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.Order;
import com.example.shop.OrderItem;
import com.example.shop.OrderService;
import com.example.shop.OrderStatus;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();

    private Order createSampleOrder() {
        Order order = new Order();
        order.addItem(new OrderItem("Item", 1, 100.0));
        return order;
    }

    @Test
    void cancelsOrderForInvalidPayment() {
        Order order = createSampleOrder();

        double result = service.processOrder(order, null, "crypto");

        assertEquals(0.0, result);
        assertEquals(OrderStatus.CANCELLED, order.getStatus());
    }

    @Test
    void processesOrderSuccessfullyWithDiscount() {
        Order order = createSampleOrder();

        double result = service.processOrder(order, "STUDENT10", "card");

        assertEquals(OrderStatus.PAID, order.getStatus());
        assertTrue(result > 0);
    }

    @Test
    void throwsForUnsupportedPaymentMethod() {
        Order order = createSampleOrder();

        assertThrows(UnsupportedOperationException.class,
                () -> service.processOrder(order, null, "cash"));
    }
}
