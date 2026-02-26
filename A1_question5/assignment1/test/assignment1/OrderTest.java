package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.Order;
import com.example.shop.OrderItem;
import com.example.shop.OrderService;
import com.example.shop.OrderStatus;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addsItemWhenStatusCreated() {
        Order order = new Order();
        order.addItem(new OrderItem("Pen", 1, 2.0));

        assertEquals(1, order.getItems().size());
        assertEquals(OrderStatus.CREATED, order.getStatus());
    }

    @Test
    void cannotAddItemAfterOrderProcessed() {
        Order order = new Order();
        order.addItem(new OrderItem("Pen", 1, 2.0));

        OrderService service = new OrderService();
        service.processOrder(order, null, "card");

        assertThrows(IllegalStateException.class,
                () -> order.addItem(new OrderItem("Book", 1, 5.0)));
    }
}

