package org.example.controller;

import org.example.ArrayManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MaxValueController {
    @Autowired
    ReaderFromXlsx reader;

    @GetMapping("/values")
    Integer searchValue(@RequestParam("filePath") String filePath, @RequestParam("number") int N) throws IOException {
        int[] arr = reader.read(filePath);
        if (N <=0 || N >= arr.length)
            return null;
        ArrayManager.sort(arr);
        return arr[N-1];
    }
}
