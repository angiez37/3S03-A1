import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest{
private DivideCycle2 d = new DivideCycle2();
@Test  
public void testNormalDivision() {  
                assertEquals(2, d.divide(4, 2));  
}  

@Test  
public void testDivisionByZero() {  
assertThrows(ArithmeticException.class, () -> d.divide(4, 0)); 

} 


//new test suites after initial round of TDD  

 @Test 
public void testDecimalDivision(){ 
assertEquals(3.5, d.divide(7,2)); 
} 

@Test 
public void testNegativeDivision(){ 
assertEquals(-2, d.divide( -10, 5)); 
assertEquals(2, d.divide( -10, -5)); 
assertEquals(-2, d.divide( 10, -5)); 
} 

@Test 
public void testNumeratorZero(){ 

assertEquals(0, d.divide( 0, 9)); 

} 
}