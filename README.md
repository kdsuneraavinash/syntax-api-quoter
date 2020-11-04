# The Quoter tool

> Generate the Ballerina Syntax API calls to build the given source code.

This project aims to list the required API calls to create the given source code's syntax tree. 
This project will be useful for anyone who uses the Ballerina syntax API to create source code elements.

## 🌐 Web-Based tool

> The Online version of the web tool can be found in [http://46.101.157.247/](http://46.101.157.247/).

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

```bash
usage: ./quote [OPTIONS]
 -i,--input <arg>          input file path
 -o,--output <arg>         output file path
 -s,--stdout               output to stdout
 -f,--formatter <arg>      formatter name (none,default,variable)
 -u,--use-template <arg>    whether to use template (true/false)
 -t,--template <arg>       template to use (applicable only if use template is true)
 -p,--position <arg>       tab position to start (applicable only if use template is true)
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
```

## Generating child names JSON

Application projects rely on [`child-names.json`](quoter/src/main/resources/quoter.properties) file to get the names of the children 
of each node type. If the Syntax API is changed, this file should be updated.
 This can be done by running the `scripts/generate.py` file. This script will use the 
 `scripts/syntax_tree_descriptor.json` file to generate the required JSON files. 
 The newest version of `syntax_tree_descriptor.json` can be acquired from the 
 [`treegen source`](https://github.com/ballerina-platform/ballerina-lang/blob/master/compiler/ballerina-treegen/src/main/resources/syntax_tree_descriptor.json).

```bash
$ cd scripts
$ curl https://raw.githubusercontent.com/ballerina-platform/ballerina-lang/master/compiler/ballerina-treegen/src/main/resources/syntax_tree_descriptor.json -o syntax_tree_descriptor.json -s
$ python generate.py
```

## Implementation

For implementation details refer to [this document](docs/README.md).
