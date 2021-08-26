package com.wjh.common.id;

import java.util.Random;

public class SnowFlake {
    public static long getId() {
        String s = "0" + getTimestampInBitStr() + getMachineIdInBitStr() + getSeqInBitStr();
        return Long.parseLong(s, 2);
    }

    /**
     * 获得41位时间戳的01字符串
     *
     * @return 例如 10100111101110010010110000011001111011001  共41位
     */
    private static String getTimestampInBitStr() {
        Long _100YearsInMillis = 189216000000L;// 100*365*24*60*60*60 即100年
        long currentTimeMillis = System.currentTimeMillis();
        long timeMillis = currentTimeMillis - _100YearsInMillis;// 为了使时间戳能多用100年
        return Long.toString(timeMillis, 2);
    }

    /**
     * 获得10位的机器id,机器id可以从配置文件中读取，
     * 每台机器的机器id配置成不同的
     */
    private static String getMachineIdInBitStr() {
        return "0000000001";// TODO
    }

    /**
     * 获得12位的序列
     * 可以使用随机的方式
     */
    private static String getSeqInBitStr() {
        String seq = "";
        Random random = new Random();
        for (int i = 0; i < 12; i++) seq += random.nextInt(2);
        return seq;
    }
}
