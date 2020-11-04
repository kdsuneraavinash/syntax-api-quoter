# The Quoter CLI tool

> CLI application for the quoter tool.

### Basic Usage

Run the following command from this directory. 
It will parse the source code from the `input.bal` file in this directory and generate the 
output code to `output.txt`. 

```bash
$ ./quote
```

Note: If on Windows, use `../gradlew.bat quoter -q -Pprops="[OPTIONS]"` from this directory
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

Default properties can be changed via changing the [`quoter.properties`](src/main/resources/quoter.properties) file. 
Note that the argument values will override these settings even if provided. All the paths in this file will be 
relative to this directory.

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

