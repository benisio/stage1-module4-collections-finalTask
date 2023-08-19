package com.epam.mjc.collections.combined;

import java.util.*;
import java.util.stream.Collectors;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
        return timetable.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    /*public static void main(String[] args) {
        var obj = new LessonsGetter();
        Map<String, List<String>> timetable = new HashMap<>();
        timetable.put("Monday", List.of("English"));
        timetable.put("Tuesday ", List.of("Mathematics"));
        timetable.put("Wednesday ", List.of("English", "Chemistry"));
        timetable.put("Thursday ", List.of("Literature", "Mathematics"));
        timetable.put("Friday ", List.of("Physics"));
        obj.getLessons(timetable).forEach(System.out::println);
    }*/
}