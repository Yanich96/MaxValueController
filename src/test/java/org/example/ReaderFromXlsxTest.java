package org.example;

import org.example.controller.ReaderFromXlsx;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReaderFromXlsxTest {

    @Test
    public void checkRead() throws IOException {
        ReaderFromXlsx reader = new ReaderFromXlsx();
        int[] arr = new int[]{3, 5, 7, 1, 8, 2, 9, 0};
        int[] arr1 = new int[]{3, 5, 7, 1, 8, 2, 9};
        int[] res = reader.read("./src/test/java/resources/test1.xlsx");
        Assert.assertNotNull(res);
        Assert.assertEquals(res.length, arr.length);
        Assert.assertArrayEquals(res, arr);
        Assert.assertFalse(Arrays.equals(res, arr1));
    }

    @Test
    public void isFileIsEmpty() throws IOException {
        ReaderFromXlsx reader = new ReaderFromXlsx();
        int[] res = reader.read("./src/test/java/resources/test2.xlsx");
        Assert.assertArrayEquals(res, new int[0]);
    }

    @Test
    public void checkFileNotFound() throws IOException {
        ReaderFromXlsx reader = new ReaderFromXlsx();
        Assert.assertThrows(FileNotFoundException.class, () -> reader.read(""));
    }


}
