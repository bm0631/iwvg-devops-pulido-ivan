package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    Fraction fraction;

    @BeforeEach
    void before() {
        this.fraction = new Fraction(2, 3);
    }

    @Test
    void testNewEmptyFraction() {
        this.fraction = new Fraction();
        assertEquals(1, this.fraction.getNumerator());
        assertEquals(1, this.fraction.getDenominator());
    }

    @Test
    void testNewFraction() {
        assertEquals(2, this.fraction.getNumerator());
        assertEquals(3, this.fraction.getDenominator());
    }

    @Test
    void testSetNumeratorFraction() {
        this.fraction.setNumerator(4);
        assertEquals(4, this.fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        this.fraction.setDenominator(5);
        assertEquals(5, this.fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        double expectedDouble = ((double) 2 / 3);
        assertEquals(expectedDouble, this.fraction.decimal());
    }

    @Test
    void testToString() {
        String stringExpected = "Fraction{" +
                "numerator=2" +
                ", denominator=3" +
                '}';
        assertEquals(stringExpected, this.fraction.toString());
    }

    @Test
    void testIsPopper() {
        assertTrue(this.fraction.isPopper());
        this.fraction = new Fraction(1, 1);
        assertTrue(this.fraction.isPopper());
        this.fraction = new Fraction(5, 3);
        assertFalse(this.fraction.isPopper());
    }

    @Test
    void testIsImproper() {
        assertFalse(this.fraction.isImproper());
        this.fraction = new Fraction(4, 4);
        assertFalse(this.fraction.isImproper());
        this.fraction = new Fraction(6, 4);
        assertTrue(this.fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction = new Fraction(4, 6);
        assertTrue(this.fraction.isEquivalent(fraction));
        Fraction fraction2 = new Fraction(1, 6);
        assertFalse(this.fraction.isEquivalent(fraction2));
    }

    @Test
    void testAdd() {
        Fraction fraction = new Fraction(1, 3);
        this.fraction.add(fraction);
        assertEquals(3, this.fraction.getNumerator());
        assertEquals(3, this.fraction.getDenominator());

        Fraction fraction2 = new Fraction(1, 2);
        this.fraction.add(fraction2);
        assertEquals(9, this.fraction.getNumerator());
        assertEquals(6, this.fraction.getDenominator());

    }

    @Test
    void testMultiply() {
        Fraction fraction = new Fraction(2, 3);
        this.fraction.multiply(fraction);
        assertEquals(4, this.fraction.getNumerator());
        assertEquals(9, this.fraction.getDenominator());

    }

    @Test
    void testDivide() {
        Fraction fraction = new Fraction(2, 4);
        this.fraction.divide(fraction);
        assertEquals(8, this.fraction.getNumerator());
        assertEquals(6, this.fraction.getDenominator());

    }

}
