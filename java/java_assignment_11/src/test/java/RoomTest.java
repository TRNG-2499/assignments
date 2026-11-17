import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room kitchen;
    private Room bedroom;

    @BeforeEach
    void setUp() {
        kitchen = new Room("Kitchen", "The Kitchen");
        bedroom = new Room("Bedroom", "The Bedroom");
    }

    @Test
    void constructorSetsNameAndDescription() {
        assertEquals("Kitchen", kitchen.getName());
        assertEquals("The Kitchen", kitchen.getDescription());
    }

    @Test
    void newRoomHasNoExits() {
        assertTrue(kitchen.getExits().isEmpty());
    }

    @Test
    void connectRoomLinksBothDirections() {
        kitchen.connectRoom(bedroom, Direction.EAST);
        assertSame(bedroom, kitchen.getExits().get(Direction.EAST));
        assertSame(kitchen, bedroom.getExits().get(Direction.WEST));
    }
}
