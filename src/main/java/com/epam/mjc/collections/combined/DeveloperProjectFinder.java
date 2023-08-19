package com.epam.mjc.collections.combined;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        return projects
                .entrySet()
                .stream()
                .flatMap(entry -> {
                    var project = entry.getKey();
                    var projectDevs = entry.getValue();
                    if (projectDevs.contains(developer)) {
                        return Stream.of(project);
                    }
                    return Stream.empty();
                })
                .sorted(projectsComparator)
                .collect(Collectors.toList());
    }

    private Comparator<String> projectsComparator =
            Comparator
                    .comparingInt(String::length)
                    .reversed()
                    .thenComparing(Comparator.reverseOrder());
}