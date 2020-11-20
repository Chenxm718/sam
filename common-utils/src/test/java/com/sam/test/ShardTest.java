package com.sam.test;

import org.junit.Test;

/**
 * @author ChenXinmin
 * @date 2020/11/20 9:04
 */
public class ShardTest {

    @Test
    public void testShard(){
        System.out.println(Math.abs(new Long(1009527380).hashCode())%32 +1);
        System.out.println(Math.abs(("15047250012").hashCode())%32 +1);
    }

    @Test
    public void testSeat(){
        String seat="1排6座";
        seat = seat.trim().replace(" ","");
        seat = seat.trim().replace("排",",");
        seat = seat.trim().replace("座",",");
        System.out.println(seat);
        System.out.println(seat.split(",")[0]);
        System.out.println(seat.split(",")[1]);
    }
}
