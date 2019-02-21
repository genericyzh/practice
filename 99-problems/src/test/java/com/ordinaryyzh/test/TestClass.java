package com.ordinaryyzh.test;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @date 2017/6/9 15:57
 */
public class TestClass {
    @Test
    public void testFilePath() {
        try {
            Files.createDirectories(Paths.get("D:/BRubik/logs/exception/"));
            Files.createDirectories(Paths.get("D:/BRubik/logs/admin/"));
            Files.createDirectories(Paths.get("D:/BRubik/logs/enet/"));
            Files.createDirectories(Paths.get("D:/BRubik/logs/lzua/p/"));
            Files.createDirectories(Paths.get("D:/BRubik/logs/lzua/cu/"));
            Files.createDirectories(Paths.get("D:/logs/BRubik/rubik.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
