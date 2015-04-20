package org.bongiorno.algorithms.brainteasers;

/**
 * Created by IntelliJ IDEA.
 * User: christian
 * Date: 3/21/12
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindRepeating {
    
    public static int byXor(int... values) {

        for (int i = 1; i < values.length; i++)
        {
            values[i] = values[i] ^ values[i-1] ^ i;
        }

        return values[values.length -1];
    }
    
    public static int bySum(int ... values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum - ((values.length * (values.length -1)) /2);
    }
}
