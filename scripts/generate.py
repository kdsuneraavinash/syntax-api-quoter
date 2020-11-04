import json
import os


# syntax_tree_descriptor of tree-gen
SYNTAX_TREE_DESCRIPTOR = 'syntax_tree_descriptor.json'
CHILD_NAMES = '../src/main/resources/child-names.json'

dirname = os.path.dirname(__file__)


def main():
    """
    Main entry point
    """

    # Read the source json
    with open(os.path.join(dirname, SYNTAX_TREE_DESCRIPTOR), 'r') as fr:
        data = json.load(fr)

    # Process each node entry
    output = {}
    for node in data["nodes"]:
        name = node["name"]
        attributes = node.get("attributes", [])
        attributes = map(lambda attr: attr["name"], attributes)
        output[name] = list(attributes)

    # Output the json
    with open(os.path.join(dirname, CHILD_NAMES), 'w') as fw:
        json.dump(output, fw)


if __name__ == "__main__":
    main()
