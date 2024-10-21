package com.example.test.type;

public enum SortDirection {
    DESC("desc"), ASC("asc");

    public final String label;

    SortDirection(String label) {
        this.label = label;
    }

    public static SortDirection parseString(String s) {
        if (s.equalsIgnoreCase("asc")) return SortDirection.ASC;
        if (s.equalsIgnoreCase("desc")) return SortDirection.DESC;
        throw new IllegalArgumentException();

    }
}