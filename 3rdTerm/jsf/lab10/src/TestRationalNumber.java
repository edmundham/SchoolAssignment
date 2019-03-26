import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestRationalNumber {

    @Test
    public void testConstructor() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testReciprocal() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r1Reciprocal = new RationalNumber(8, 6);
        RationalNumber r3 = r1.reciprocal();
        assertEquals(r1Reciprocal, r3);
    }

    @Test
    public void testAdd() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        RationalNumber r4_test = new RationalNumber(26, 24);
        RationalNumber r4 = r1.add(r2);
        assertEquals(r4, r4_test);
    }

    @Test
    public void testSubtract() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        RationalNumber r4_test = new RationalNumber(10, 24);
        RationalNumber r4 = r1.subtract(r2);
        assertEquals(r4, r4_test);
    }

    @Test
    public void testMultiply() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        RationalNumber r4_test = new RationalNumber(6, 24);
        RationalNumber r4 = r1.multiply(r2);
        assertEquals(r4, r4_test);
    }

    @Test
    public void testDivide() {
        RationalNumber r1 = new RationalNumber(6, 8);
        RationalNumber r2 = new RationalNumber(1, 3);
        RationalNumber r4_test = new RationalNumber(9, 4);
        RationalNumber r4 = r1.divide(r2);
        assertEquals(r4, r4_test);
    }

    @Test
    public void testZeroDenominator() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RationalNumber(2, 0);
        });
    }

    @Test
    public void testZeroReciprocal() {
        assertThrows(IllegalArgumentException.class, () -> {
            RationalNumber.ZERO.reciprocal();
        });
    }

    @Test
    public void testDivideZero() {
        assertThrows(IllegalArgumentException.class, () -> {
           new RationalNumber(1,1).divide(RationalNumber.ZERO);
        });
    }

}
