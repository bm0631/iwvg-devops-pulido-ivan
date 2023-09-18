package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchesTest {
    Searches searches;

    @BeforeEach
    void before() {
        searches = new Searches();
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        List<Double> resulList = this.searches.findDecimalFractionByNegativeSignFraction().toList();
        assertEquals(2, resulList.size());
        assertTrue(resulList.contains(-0.2));
        assertTrue(resulList.contains(-0.5));
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction() {
        List<String> resulList = this.searches.findUserFamilyNameInitialBySomeProperFraction().toList();
        assertEquals(3, resulList.size());
        assertTrue(resulList.contains("O."));
        assertTrue(resulList.contains("A."));
        assertTrue(resulList.contains("P."));
    }

    @Test
    void testFindFractionAdditionByUserId() {
        Fraction fractionResult1 = this.searches.findFractionAdditionByUserId("1");
        assertEquals(3, fractionResult1.getNumerator());
        assertEquals(1, fractionResult1.getDenominator());

        Fraction fractionExpected = new Fraction(109, 30);
        Fraction fractionResult2 = this.searches.findFractionAdditionByUserId("2");
        assertTrue(fractionExpected.isEquivalent(fractionResult2));

    }
}
