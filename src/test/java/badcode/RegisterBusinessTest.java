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
                    null.register(null, business);
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
                    new Speaker().register(null, business);
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
                    speaker.register(null, business);
                }
        );
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email = null ดังนั้นจะโยน ArgumentNullException ออกมา" +
            "พร้อมกับคำว่า Email is required.")
    void case04() {
        RegisterBusiness business = new RegisterBusiness();
        // Prepare
        Speaker speaker = new Speaker();
        speaker.setFirstName("Yuranan");
        speaker.setLastName("Charoen-ngarm");
        // Assert exception with JUnit 5?
        Exception exception = assertThrows(ArgumentNullException.class, () ->{
                    speaker.register(null, business);
                }
        );
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("email invalid domain ดังนั้นจะโยน SpeakerDoesntMeetRequirementsException ออกมา" +
            "พร้อมกับคำว่า Speaker doesn't meet our standard rules.")
    void case05() {
        RegisterBusiness business = new RegisterBusiness();
        // Prepare
        Speaker speaker = new Speaker();
        speaker.setFirstName("Yuranan");
        speaker.setLastName("Charoen-ngarm");
        speaker.setEmail("abc@amail.com");
        // Assert exception with JUnit 5?
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () ->{
                    speaker.register(null, business);
                }
        );
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("SpeakerRepository is null ดังนั้นจะโยน SaveSpeakerException ออกมา" +
            "พร้อมกับคำว่า Can't save a speaker.")
    void case06() {
        RegisterBusiness business = new RegisterBusiness();
        // Prepare
        Speaker speaker = new Speaker();
        speaker.setFirstName("Yuranan");
        speaker.setLastName("Charoen-ngarm");
        speaker.setEmail("abc@gmail.com");
        // Assert exception with JUnit 5?
        Exception exception = assertThrows(SaveSpeakerException.class, () ->{
                    speaker.register(null, business);
                }
        );
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

    @Test
    @DisplayName("Invalid email domain ดังนั้นจะโยน DomainEmailInvalidException ออกมา" +
            "พร้อมกับคำว่า ")
    void case07() {
        RegisterBusiness business = new RegisterBusiness();
        // Prepare
        Speaker speaker = new Speaker();
        speaker.setFirstName("Yuranan");
        speaker.setLastName("Charoen-ngarm");
        speaker.setEmail("abc");
        // Assert exception with JUnit 5?
        Exception exception = assertThrows(DomainEmailInvalidException.class, () ->{
                    speaker.register(null, business);
                }
        );
        //assertEquals("Can't save a speaker.", exception.getMessage());
    }

//    @Test
//    @DisplayName("SetExp = 0 ดังนั้นจะโยน ArgumentNullException ออกมา" +
//            "พร้อมกับคำว่า Can't save a speaker.")
//    void case08() {
//        RegisterBusiness business = new RegisterBusiness();
//        // Prepare
//        Speaker speaker = new Speaker();
//        speaker.setFirstName("Yuranan");
//        speaker.setLastName("Charoen-ngarm");
//        speaker.setEmail("abc@gmail.com");
//        speaker.setExp(0);
//        // Assert exception with JUnit 5?
//        Exception exception = assertThrows(SaveSpeakerException.class, () ->{
//                    business.register(null , speaker);
//                }
//        );
//        assertEquals("", exception.getMessage());
//    }
}