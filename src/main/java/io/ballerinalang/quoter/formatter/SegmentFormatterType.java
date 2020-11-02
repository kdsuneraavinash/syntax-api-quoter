package io.ballerinalang.quoter.formatter;

import io.ballerinalang.quoter.QuoterException;

/**
 * Formatter types available.
 */
public enum SegmentFormatterType {
    NO_FORMATTER("none"),
    VARIABLE_FORMATTER("variable"),
    DEFAULT_FORMATTER("default");

    private final String name;

    SegmentFormatterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Get the segment formatter type associated with the string representation.
     * Throws an error if formatter name is unknown.
     *
     * @param name Name of the formatter.
     * @return Formatter type.
     */
    public static SegmentFormatterType getSegmentFormatterType(String name) {
        switch (name) {
            case "none":
                return NO_FORMATTER;
            case "variable":
                return VARIABLE_FORMATTER;
            case "default":
                return DEFAULT_FORMATTER;
            default:
                throw new QuoterException("Unknown formatter type");
        }
    }
}
