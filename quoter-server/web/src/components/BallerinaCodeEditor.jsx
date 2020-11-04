import React, {useContext} from "react";
import MonacoEditor from "react-monaco-editor";

import {ballerinaMonacoOptions} from "./MonacoOptions";
import grammar from "./../ballerina.monarch.json";
import {AppStateContext} from "./AppState";
import "./CodeEditor.css";


const BALLERINA_LANG = "ballerina";

function BallerinaCodeEditor() {
    const {state, setCode} = useContext(AppStateContext);

    return (
        <div className={`code-editor ballerina-code-editor bg-${state.ide.theme}`}>
            <MonacoEditor
                theme={state.ide.theme}
                language={BALLERINA_LANG}
                options={ballerinaMonacoOptions()}
                defaultValue={state.code}
                onChange={setCode}
                editorDidMount={(editor, {languages}) => {
                    languages.register({id: BALLERINA_LANG});
                    languages.setMonarchTokensProvider(BALLERINA_LANG, {
                        tokenizer: grammar,
                    });
                }}
            />
        </div>
    );
}

export default BallerinaCodeEditor;
