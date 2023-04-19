import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestInit {
    @Test
    public void testInit() {
        Systeme sys = new Systeme();
        assertTrue(sys.getWaiting().isEmpty());
        assertTrue(sys.isCurrent(null));
        assertTrue(sys.isLast(null));
    }
}
