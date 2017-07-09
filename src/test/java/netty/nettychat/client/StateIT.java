/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netty.nettychat.client;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shaldnikita
 */
public class StateIT {
    
    public StateIT() {
    }

    /**
     * Test of values method, of class State.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        State[] expResult = null;
        State[] result = State.values();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class State.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        State expResult = null;
        State result = State.valueOf(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
