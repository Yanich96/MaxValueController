package org.example;


import org.example.controller.MaxValueController;
import org.example.controller.ReaderFromXlsx;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {Main.class, ReaderFromXlsx.class, MaxValueController.class})
@WebMvcTest(value = MaxValueController.class)
public class MaxValueControllerTest {

    @Autowired
    ReaderFromXlsx reader;
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("argsForCheckWrongN")
    void checkWrongN(String filePath, String number, String expectedValue) throws Exception {
        mockMvc.perform(get("/values")
                        .param("filePath",
                                filePath)
                        .param("number", number)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedValue));
    }

    private static Stream<Arguments> argsForCheckWrongN() {
        return Stream.of(
                Arguments.of(
                        "./src/test/java/resources/test1.xlsx",
                        "3",
                        "7"),
                Arguments.of(
                        "./src/test/java/resources/test1.xlsx",
                        "30",
                        ""),
                Arguments.of(
                        "./src/test/java/resources/test1.xlsx",
                        "0",
                        ""),
                Arguments.of(
                        "./src/test/java/resources/test1.xlsx",
                        "-3",
                        "")
        );
    }
}

