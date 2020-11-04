# The Quoter tool

> Generate the Ballerina Syntax API calls to build the given source code.

This project aims to list the required API calls to create the given source code's syntax tree. 
This project will be useful for anyone who uses the Ballerina syntax API to create source code elements.

## 🌐 Web-Based tool

**The web project source code can be found in [quoter-server](../quoter-server) module.**
## 💻 Command Line Tool

**The command line tool project source code can be found in [quoter-cli](../quoter-cli) module.**

## Generating child names JSON

Application projects rely on [`child-names.json`](src/main/resources/quoter.properties) file to get the names of the children 
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

For implementation details refer to [this document](../docs/README.md).
