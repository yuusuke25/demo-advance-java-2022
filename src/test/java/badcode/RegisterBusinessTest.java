package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("ข้อมูล speaker = null จะโยน runtime exception กลับมา" +
            "พร้อมกับ message Speaker is null")
    void case01() {
        RegisterBusiness business = new RegisterBusiness();

        // Assert exception with JUnit 5?
        Exception exception = assertThrows(RuntimeException.class, () ->{
                    business.register(null , null);
                }
        );

        assertEquals("Speaker is null", exception.getMessage());
    }

    @Test
    @DisplayName("First name = null ดังนั้นจะโยน ArgumentNullException ออกมา" +
            "พร้อมกับคำว่า First name is required.")
    void case02() {
        RegisterBusiness business = new RegisterBusiness();

        // Assert exception with JUnit 5?
        Exception exception = assertThrows(ArgumentNullException.class, () ->{
                    business.register(null , new Speaker());
                }
        );

        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Last name = null ดังนั้นจะโยน ArgumentNullException ออกมา" +
            "พร้อมกับคำว่า Last name is required.")
    void case03() {
        RegisterBusiness business = new RegisterBusiness();
        // Prepare
        Speaker speaker = new Speaker();
        speaker.setFirstName("Yuranan");
        // Assert exception with JUnit 5?
        Exception exception = assertThrows(ArgumentNullException.class, () ->{
                    business.register(null , speaker);
                }
        );
        assertEquals("Last name is required.", exception.getMessage());
    }
}