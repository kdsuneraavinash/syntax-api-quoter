# The Quoter CLI tool

> CLI application for the quoter tool.

### Basic Usage

Run the following command from this directory. It will parse the source code from the `input.bal` file in this directory
and generate the output code to `output.txt`.

```bash
$ ./quote
```

Note: If on Windows, use `../gradlew.bat quoter -q -Pprops="[OPTIONS]"` from this directory to directly run the gradle
task.

You can also build the jar and run it directly. Remember that, in this case, input file is relative to the jar file
location.

```bash
$ ./gradlew quoter-cli:fatJar
$ cd quoter-cli/build/libs
$ java -jar quoter-cli-1.0-SNAPSHOT.jar [OPTIONS]
```

You can override the default properties passing arguments.

```text
Usage: quote [-hmsuV] [-f=<formatter>] -i=<input> [-o=<output>] [-p=<parser>]
             [--position=<position>] [-t=<template>] [-x=<parserTimeout>]
Syntax API Quoter for Ballerina Language.
  -f, --formatter=<formatter>
                          formatter name
  -h, --help              Show this help message and exit.
  -i, --input=<input>     input file path
  -m, --ignore-minutiae   whether to ignore minutiae (whitespaces)
  -o, --output=<output>   output file path
  -p, --parser=<parser>   parser name
      --position=<position>
                          tab position to start (applicable only if use
                            template is true)
  -s, --stdout            output to stdout
  -t, --template=<template>
                          template to use (applicable only if use template is
                            true)
  -u, --use-template      whether to use templates
  -V, --version           Print version information and exit.
  -x, --timeout=<parserTimeout>
                          parser timeout (in milliseconds)
```

If `--use-template` is set to true, the specified `--template` template file will be used along with the content
formatted according to the `--formatter` specified. The initial tab position of the content can be specified
using `--position`
parameter. In the template, the content will be replaced with the `%s`.

### Example Usages

| Command                                                      | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `./quote -f default`                       | Override and use default formatter                           |
| `./quote -i code.bal -s true`              | Read from `code.bal` and output generated code to standard output as well |
| `./quote -f template -t Template.java -p 2`| Use the template formatter with `Template.java` as template and 2 as the starting tab space |

### Changing Default Properties of CLI application

Default properties can be changed via changing the [`quoter.properties`](src/main/resources/quoter.properties) file.
Note that the argument values will override these settings even if provided. All the paths in this file will be relative
to this directory.

```properties
#Input source code file path
external.cli.input.file=input.bal
#Output file path
external.cli.output.file=output.txt
#Whether to output to the stdout
external.cli.output.sys.out=true
#Default Formatter name to use
external.formatter.name=default
#Whether to use a template
external.formatter.use.template=false
#Template path
external.formatter.template=template.txt
#Tab position in template mode
external.formatter.tab.start=2
#Parser to use
external.parser.name=module
#Timeout for the parser (milliseconds)
external.parser.timeout=100
#Whether to discard minutiae info
external.ignore.minutiae=false
```

