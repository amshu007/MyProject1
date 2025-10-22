package com.example.rating.test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Consecutive
{

    public static void main(String[] args) {
        String s = "aaaaatttttppppbbbbbbbb";

        Map<String, Long> collect =
                Arrays.asList(s.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);


    }
}
