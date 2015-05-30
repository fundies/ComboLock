package combolock;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg Williamson
 * @version 0.1
 */
public class ComboLock {
    private final int[] combo = new int[3];
    private final int[] tryCombo = new int[3];

    private int dial;
    private int state;

    /**
     * Gets the current position of the dial.
     *
     * @return the position
     */
    public final int getDial() {
        return dial;
    }

    /**
     * Sets the current position of the dial.
     *
     * @param pos set dial to this position.
     */
    public final void setDial(final int pos) {
        dial = pos;
    }

    /**
     * Construct a combination lock with three numbers.
     *
     * @param secret1 first digit of combo
     * @param secret2 second digit of combo
     * @param secret3 third digit of combo
     */
    public ComboLock(final int secret1, final int secret2, final int secret3) {
        combo[0] = secret1;
        combo[1] = secret2;
        combo[2] = secret3;

        state = 0;
        dial = 0;
    }

    /**
     * Reset the Lock to 0.
     */
    public final void reset() {
        state = 0;
        dial = 0;
        tryCombo[0] = tryCombo[1] = tryCombo[2] = 0;
    }

    /**
     * Turn the lock Left.
     *
     * @param ticks number of ticks user moves left.
     */
    public final void turnLeft(final int ticks) {
        if (state == 1) {
            dial += ticks;
            dial %= 40;
            tryCombo[state++] = dial;
        } else {
            reset();
        }
    }

    /**
     * Turn the lock Right.
     *
     * @param ticks number of ticks user moves right.
     */
    public final void turnRight(final int ticks) {
        if ((state == 0) || state == 2) {
            dial += 40 - (ticks % 40);
            tryCombo[state++] = dial;
        } else {
            reset();
        }
    }

    /**
     * Test if lock is unlocked.
     *
     * @return returns true if unlocked false if locked
     */
    public final boolean open() {
        Object[] a1 = { combo };
        Object[] a2 = { tryCombo };
        return Arrays.deepEquals(a1, a2);
    }
}