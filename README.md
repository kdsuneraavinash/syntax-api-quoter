# The Quoter tool

> Generate the Ballerina Syntax API calls to build the given source code.

This project aims to list the required API calls to create the given source code's syntax tree. 
This project will be useful for anyone who uses the Ballerina syntax API to create source code elements.

## 🌐 Web-Based tool

> The Online version of the web tool can be found in [https://github.com/ballerina-platform/ballerina-lang](https://github.com/ballerina-platform/ballerina-lang).

![Web tool screenshot](docs/web.png)

### Basic Usage

Enter the ballerina source code on the left-hand side pane and press the button to generate the respective Java Syntax 
API calls. The code can be copied to the clipboard using the copy button. Formatter can be changed via the settings button.

## 💻 Command Line Tool

### Basic Usage

Run the following command from the project root. It will parse the source code from the `input.bal` file and generate the 
output code to `output.txt`.

```bash
$ ./gradlew quoter
```

You can override the default properties by the `-Props` argument. 

```bash
usage: ./gradlew quoter -Props="[OPTIONS]"
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
| `./gradlew quoter -Props="-f default"`                       | Override and use default formatter                           |
| `./gradlew quoter -Props="-i code.bal -s true"`              | Read from `code.bal` and output generated code to standard output as well |
| `./gradlew quoter -Props="-f template -t Template.java -p 2"` | Use the template formatter with `Template.java` as template and 2 as the starting tab space |

### Changing Default Properties

Default properties can be changed via changing the [`quoter.properties`](src/main/resources/quoter.properties) file. 
Note that the `-Props` values will override these settings even if changed. All the paths in this file will be 
relative to the project root.

```properties
# suppress inspection "UnusedProperty" for whole file
#Input source code file path
external.input.file=input.bal
#Output file path
external.output.file=output.txt
#Whether to output to the stdout
external.output.sys.out=true
#Default Formatter name to use
external.formatter.name=default
#Whether to use a template
external.formatter.use.template=false
#Template path
external.formatter.template=template.txt
#Tab position in template mode
external.formatter.tab.start=2
```

The project relies on [`child-names.json`](src/main/resources/quoter.properties) file to get the names of the children 
of each node type. If the Syntax API is changed, this file should be updated.
 This can be done by running the `scripts/generate.py` file. This script will use the 
 `scripts/syntax_tree_descriptor.json` file to generate the required JSON files. 
 The newest version of `syntax_tree_descriptor.json` can be acquired from the 
 [`treegen source`](https://github.com/ballerina-platform/ballerina-lang/blob/master/compiler/ballerina-treegen/src/main/resources/syntax_tree_descriptor.json).

```bash
$ cd scripts
$ python generate.py
```

## Implementation

For implementation details refer to [this document](docs/Design.md).
