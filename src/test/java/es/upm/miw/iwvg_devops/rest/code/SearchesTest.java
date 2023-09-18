package es.upm.miw.iwvg_devops.rest.code;

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

}
