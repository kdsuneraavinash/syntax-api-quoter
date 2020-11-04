import React, {useContext} from "react";
import MonacoEditor from "react-monaco-editor";

import javaLanguageDefinition from "../java.monarch";
import {javaMonacoOptions} from "./MonacoOptions";
import {AppStateContext} from "./AppState";
import "./CodeEditor.css";


const JAVA_LANG = "java";

function JavaCodeEditor() {
    const {state: {generated, ide}} = useContext(AppStateContext);

    return (
        <div className={`code-editor bg-${ide.theme}`}>
            <MonacoEditor
                theme={ide.theme}
                language={JAVA_LANG}
                options={javaMonacoOptions()}
                value={generated}
                editorDidMount={(editor, {languages}) => {
                    languages.register({id: JAVA_LANG});
                    languages.setMonarchTokensProvider(JAVA_LANG, javaLanguageDefinition());
                }}
            />
        </div>
    );
}

export default JavaCodeEditor;
