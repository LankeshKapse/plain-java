package org.lucky.jdks.jdk11;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Features {
    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        assertIterableEquals(withoutBlanks,List.of("Java","Kotlin"));

        List<String> sampleList2 = Arrays.asList("Java", "Kotlin",null);
        String resultString = sampleList2.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ".strip()));
        assertEquals(resultString,"JAVA,KOTLIN");
    }
}
