# The Quoter tool

> Generate the Ballerina Syntax API calls to build the given source code.

This project aims to list the required API calls to create the given source code's syntax tree. 
This project will be useful for anyone who uses the Ballerina syntax API to create source code elements.

## 🌐 Web-Based tool

> The Online version of the web tool can be found in [demo site](http://quoter.kdsuneraavinash.me/).

![Web tool screenshot](docs/web.png)

**The web project source code can be found in [quoter-server](./quoter-server) directory.**

### Basic Usage

Enter the ballerina source code on the left-hand side pane and press the button to generate the respective Java Syntax 
API calls. The code can be copied to the clipboard using the copy button. Formatter can be changed via the settings button.

To build and run the web project, run the gradle task `bootRun`.

```bash
$ ./gradlew bootRun
```

Or you may build the `war` file and then run the application.

```bash
$ ./gradlew quoter-server:build
$ cd quoter-server/build/libs
$ java -jar quoter-server-1.0-SNAPSHOT.war
```

## 💻 Command Line Tool

**The command line tool project source code can be found in [quoter-cli](./quoter-cli) directory.**

### Basic Usage

Run the following command from the [quoter-cli](quoter-cli) directory. 
It will parse the source code from the `input.bal` file in the same directory and generate the 
output code to `output.txt`. 

```bash
$ cd quoter-cli
$ ./quote
```

Note: If on Windows, use `../gradlew.bat quoter -q -Pprops="[OPTIONS]"` from the cli directory
 to directly run the gradle task.

You can also build the jar and run it directly. 
Remember that, in this case, input file is relative to the jar file location.

```bash
$ ./gradlew quoter-cli:fatJar
$ cd quoter-cli/build/libs
$ java -jar quoter-cli-1.0-SNAPSHOT.jar [OPTIONS]
```

You can override the default properties passing arguments. 

```text
Usage: quoter [-hsuV] [-f=<formatter>] -i=<input> [-o=<output>] [-p=<position>]
              [-t=<template>] [-x=<timeOut>]
Syntax API Quoter for Ballerina Language.
  -f, --formatter=<formatter>
                             formatter name
  -h, --help                 Show this help message and exit.
  -i, --input=<input>        input file path
  -o, --output=<output>      output file path
  -p, --position=<position>  tab position to start (applicable only if use
                               template is true)
  -s, --stdout               output to stdout
  -t, --template=<template>  template to use (applicable only if use template
                               is true)
  -u, --use-template         whether to use templates
  -V, --version              Print version information and exit.
  -x, --time-out=<timeOut>   time out for parsing

```

If `--use-template` is set to true, the specified `--template` template file will be used along with the content 
formatted according to the `--formatter` specified. The initial tab position of the content can be specified using `--position` 
parameter. In the template, the content will be replaced with the `%s`.

### Example Usages

| Command                                                      | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `./quote -f default`                       | Override and use default formatter                           |
| `./quote -i code.bal -s true`              | Read from `code.bal` and output generated code to standard output as well |
| `./quote -f template -t Template.java -p 2`| Use the template formatter with `Template.java` as template and 2 as the starting tab space |

### Changing Default Properties of CLI application

Default properties can be changed via changing the [`quoter.properties`](quoter-cli/src/main/resources/quoter.properties) file
in the [quoter-cli](quoter-cli) module. 
Note that the argument values will override these settings even if provided. All the paths in this file will be 
relative to the [quoter-cli](quoter-cli) directory.

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
```

## Generating child names JSON

Application projects rely on [`syntax_tree_descriptor.json`](quoter/src/main/resources/quoter.properties) file to get the names of the children of each node type. If the Syntax API is changed, this file should be updated. Simply copy and put this file from [`treegen source`](https://github.com/ballerina-platform/ballerina-lang/blob/master/compiler/ballerina-treegen/src/main/resources/syntax_tree_descriptor.json).

## Implementation

For implementation details refer to [this document](docs/README.md).
