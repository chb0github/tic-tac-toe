package brainteasers;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: christian
 * Date: 3/21/12
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBrainTeasers {

    @Test
    public void testFindDuplicate() throws Exception {
        int value = FindRepeating.byXor(1, 2, 3, 4, 6, 4, 5);
        assertEquals(4,value);

        value = FindRepeating.bySum(1, 2, 3, 4, 6, 4, 5);
        assertEquals(4,value);
    }
}
