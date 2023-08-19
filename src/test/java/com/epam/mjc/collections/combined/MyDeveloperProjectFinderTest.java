package com.epam.mjc.collections.combined;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyDeveloperProjectFinderTest {

    static DeveloperProjectFinder testObject;

    @BeforeAll
    static void createTestObject() {
        testObject = new DeveloperProjectFinder();
    }

    @Test
    void testFindDeveloperProject1() {
        var projects = Map.of(
                "CSO", Set.of("Ivan", "Anna", "Lidia", "Antony"),
                "VVas", Set.of("Mary", "Ben", "Max"),
                "LJA", Set.of("Ivan", "Oleg", "Alex")
        );
        var actualList = testObject.findDeveloperProject(projects, "Ivan");

        assertEquals(List.of("LJA", "CSO"), actualList);
    }

    @Test
    void testFindDeveloperProject2() {
        var projects = Map.of(
                "CSO", Set.of("Ivan", "Anna", "Lidia", "Antony"),
                "VVas", Set.of("Mary", "Ben", "Max"),
                "LJA", Set.of("Ivan", "Oleg", "Alex")
        );
        var actualList = testObject.findDeveloperProject(projects, "Anna");

        assertEquals(List.of("CSO"), actualList);
    }

    @Test
    void testFindDeveloperProject3() {
        var projects = Map.of("AXE", Set.of("Helen", "Bob", "Marian", "Tom"),
                "MazPay", Set.of("James", "John", "Robert"),
                "SeaV", Set.of("John", "Robert", "Angelina", "David"),
                "DelFo", Set.of("Patricia", "Jessica", "Mark", "Paul"),
                "ReaNon", Set.of("George", "Kyle", "Robert", "Brandon", "Austin"));

        var actualList = testObject.findDeveloperProject(projects, "Robert");

        assertEquals(List.of("ReaNon", "MazPay", "SeaV"), actualList);
    }

    @Test
    void testProjectsMapIsEmpty() {
        Map<String, Set<String>> projects = Map.of();
        var actualList = testObject.findDeveloperProject(projects, "Ivan");

        assertTrue(actualList.isEmpty());
    }
}