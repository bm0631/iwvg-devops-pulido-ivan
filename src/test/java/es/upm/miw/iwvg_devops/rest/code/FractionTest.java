package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
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
}
