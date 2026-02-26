package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.DiscountService;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private final DiscountService service = new DiscountService();

    @Test
    void returnsSubtotalWhenCodeIsNull() {
        assertEquals(100.0, service.applyDiscount(100.0, null));
    }

    @Test
    void returnsSubtotalWhenCodeIsBlank() {
        assertEquals(100.0, service.applyDiscount(100.0, " "));
    }

    @Test
    void appliesStudentDiscount() {
        assertEquals(90.0, service.applyDiscount(100.0, "STUDENT10"));
    }

    @Test
    void appliesBlackFridayDiscountCaseInsensitive() {
        assertEquals(70.0, service.applyDiscount(100.0, "blackfriday"));
    }

    @Test
    void throwsExceptionForInvalidCode() {
        assertThrows(IllegalArgumentException.class,
                () -> service.applyDiscount(100.0, "INVALID"));
    }

    @Test
    void returnsSubtotalForUnknownCode() {
        assertEquals(100.0, service.applyDiscount(100.0, "RANDOM"));
    }
}

