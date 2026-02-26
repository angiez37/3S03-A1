package assignment1;

import org.junit.jupiter.api.Test;

import com.example.shop.PaymentValidator;

import static org.junit.jupiter.api.Assertions.*;

class PaymentValidatorTest {

    private final PaymentValidator validator = new PaymentValidator();

    @Test
    void returnsFalseForNullPayment() {
        assertFalse(validator.isPaymentMethodValid(null));
    }

    @Test
    void acceptsValidMethods() {
        assertTrue(validator.isPaymentMethodValid("card"));
        assertTrue(validator.isPaymentMethodValid("paypal"));
    }

    @Test
    void rejectsCrypto() {
        assertFalse(validator.isPaymentMethodValid("crypto"));
    }

    @Test
    void throwsForUnknownMethod() {
        assertThrows(UnsupportedOperationException.class,
                () -> validator.isPaymentMethodValid("cash"));
    }
}

