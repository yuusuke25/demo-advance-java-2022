package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessTest {

    @Test
    @DisplayName("ข้อมูล speaker = null จะโยน runtime exception กลับมา" +
            "พร้อมกับ message Speaker is null")
    void register() {
        RegisterBusiness business = new RegisterBusiness();

        // Assert exception with JUnit 5?
        Exception exception = assertThrows(RuntimeException.class, () ->{
            business.register(null , null);
        }
        );

        assertEquals("Speaker is null", exception.getMessage());
    }
}