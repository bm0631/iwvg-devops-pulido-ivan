package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void before() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(fraction1);
        fractions.add(fraction2);
        this.user = new User("1", "Pepe", "Garcia", fractions);
    }

    @Test
    void testNewEmptyUser() {
        this.user = new User();
        assertNull(user.getId());
        assertNull(user.getFamilyName());
        assertNotNull(user.getFractions());
        assertEquals(0, user.getFractions().size());
    }

    @Test
    void testNewUser() {
        assertEquals("1", this.user.getId());
        assertEquals("Pepe", this.user.getName());
        assertEquals("Garcia", this.user.getFamilyName());
        assertEquals(2, user.getFractions().size());

    }

    @Test
    void testSetNameUser() {
        this.user.setName("TestName");
        this.user.setName("TestName");
        assertEquals("TestName", user.getName());
    }

    @Test
    void testSetFamilyNameUserInitial() {
        this.user.setFamilyName("TestFamilyName");
        assertEquals("TestFamilyName", this.user.getFamilyName());
    }

    @Test
    void testSetFractions() {
        Fraction fraction1 = new Fraction(8, 8);
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(fraction1);
        this.user.setFractions(fractions);
        assertEquals(1, this.user.getFractions().size());
    }

    @Test
    void testAddFractionUser() {
        Fraction fraction1 = new Fraction(8, 8);
        this.user.addFraction(fraction1);
        assertEquals(3, this.user.getFractions().size());
    }

    @Test
    void testFullNameUser() {
        assertEquals("Pepe Garcia", this.user.fullName());
    }

    @Test
    void testInitialsUser() {
        assertEquals("P.", this.user.initials());
    }

    @Test
    void testToStringUser() {
        String stringExpected = "User{" +
                "id='1'" +
                ", name='Pepe'" +
                ", familyName='Garcia'" +
                ", fractions=" + this.user.getFractions().toString() +
                "}";

        assertEquals(stringExpected, this.user.toString());
    }


}
