package sam.test;

import org.junit.Test;

/**
 * @Author:ChenXinmin
 * @Date:2019/6/18 14:04
 */
public class TestShard {

    @Test
    public void testShard(){
        System.out.println(Math.abs("1906120000011170700300000009".hashCode())%32 +1);
        System.out.println(Math.abs((1+"144").hashCode())%32 +1);
        System.out.println(Math.abs("E849000000000368903".hashCode()%32) +1);

    }
}
