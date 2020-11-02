/**
 * Common options for the monaco editor.
 */
const MONACO_OPTIONS = {
    autoIndent: true,
    automaticLayout: true,
    contextmenu: false,
    fontFamily: "\"Lucida Console\", Monaco, monospace",
    fontSize: 14,
    matchBrackets: true,
    minimap: {
        enabled: false,
    },
    overviewRulerBorder: false,
    overviewRulerLanes: 0,
    scrollBeyondLastLine: true,
    scrollbar: {
        useShadows: true,
    },
};

/**
 * Monaco options suited for Java text area.
 */
function javaMonacoOptions() {
    return {
        ...MONACO_OPTIONS,
        readOnly: true,
    }
}

/**
 * Monaco options suited for Ballerina text area.
 */
function ballerinaMonacoOptions() {
    return {
        ...MONACO_OPTIONS,
    }
}

export {javaMonacoOptions, ballerinaMonacoOptions};
