package io.quoter.application.cli;


/**
 * CLI option enum with the name and description.
 */
enum CmdOption {
    INPUT("input", "input file path"),
    OUTPUT("output", "output file path"),
    STDOUT("stdout", "output to stdout (true/false)"),
    FORMATTER("formatter", "formatter name (none,default,template,variable)"),
    USE_TEMPLATE("use-template", "whether to use template (true/false)"),
    TEMPLATE("template", "template to use (applicable only if use template is true)"),
    POSITION("position", "tab position to start (applicable only if use template is true)");

    final String name;
    final String description;

    CmdOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * The option parameter.
     * This is the first letter of the name.
     */
    String option() {
        return name.substring(0, 1);
    }
}
