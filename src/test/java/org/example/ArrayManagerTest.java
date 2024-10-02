package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayManagerTest {

    @ParameterizedTest
    @MethodSource("argsForCheckSort")
    public void checkSort(int[] input, int[] output){
        ArrayManager.sort(input);
        Assertions.assertArrayEquals(input, output);
    }

    private static Stream<Arguments> argsForCheckSort() {
        return Stream.of(
                Arguments.of(new int[]{6, 2, 3, 8, 1, -5}, new int[]{8, 6, 3, 2, 1, -5}),
                Arguments.of(new int[]{-4, 0, -1}, new int[]{0, -1, -4}),
                Arguments.of(new int[0], new int[0])
        );
    }
}
