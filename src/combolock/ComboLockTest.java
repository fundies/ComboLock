package combolock;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg Williamson
 * @version 0.1
 */
public class ComboLockTest {

    /**
     * Test of getDial method, of class ComboLock.
     */
    @Test
    public final void testGetDial() {
        System.out.println("getDial");
        ComboLock instance = new ComboLock(0, 0, 0);
        instance.turnRight(1);
        int result = instance.getDial();
        assertEquals(39, result);
    }

    /**
     * Test of setDial method, of class ComboLock.
     */
    @Test
    public final void testSetDial() {
        System.out.println("setDial");
        ComboLock instance = new ComboLock(0, 0, 0);
        instance.setDial(8);
        int result = instance.getDial();
        assertEquals(8, result);
    }

    /**
     * Test of reset method, of class ComboLock.
     */
    @Test
    public final void testReset() {
        System.out.println("reset");
        ComboLock instance = new ComboLock(0, 0, 0);
        instance.setDial(32);
        instance.reset();
        int result = instance.getDial();
        assertEquals(0, result);
    }

    /**
     * Test of turnLeft method, of class ComboLock.
     */
    @Test
    public final void testTurnLeft() {
        System.out.println("turnLeft");
        int ticks = 1;
        ComboLock instance = new ComboLock(0, 0, 0);

        instance.turnLeft(ticks);
        assertEquals(0, instance.getDial());

        instance.turnRight(0);
        instance.turnLeft(ticks);

        assertEquals(1, instance.getDial());
    }

    /**
     * Test of turnRight method, of class ComboLock.
     */
    @Test
    public final void testTurnRight() {
        System.out.println("turnRight");
        int ticks = 1;
        ComboLock instance = new ComboLock(0, 0, 0);
        instance.turnRight(ticks);
        instance.turnRight(ticks);
        assertEquals(0, instance.getDial());
        instance.turnRight(ticks);
        assertEquals(39, instance.getDial());
    }

    /**
     * Test of open method, of class ComboLock.
     */
    @Test
    public final void testOpen() {
        System.out.println("open");
        ComboLock instance = new ComboLock(1, 2, 3);

        assertEquals(false, instance.open());

        instance.turnRight(39);
        assertEquals(false, instance.open());

        instance.turnLeft(41);
        assertEquals(false, instance.open());

        instance.turnRight(39);
        assertEquals(true, instance.open());
    }

}
