import React, {useState} from "react";

import {AppStateProvider, InitialState, Fetch} from "./AppState";
import BallerinaCodeEditor from "./BallerinaCodeEditor";
import JavaCodeEditor from "./JavaCodeEditor";
import OverlayLoader from "./OverlayLoader";
import PlayButton from "./PlayButton";
import NavBar from "./NavBar";


function App() {
    const [state, setState] = useState(InitialState);

    /**
     * Change the ballerina code segment state.
     * @param code Modified ballerina code.
     */
    const setCode = (code) => {
        setState({...state, code});
    }

    /**
     * Sends a POST request to the server with the options and the bal code.
     * The returned text will be put in generated code state.
     * Loading state will also be changed accordingly.
     * @returns {Promise<void>}
     */
    const sendRequest = async () => {
        setState({...state, loading: true});
        const generated = await Fetch({
            code: state.code,
            formatter: state.options.formatter,
            template: state.options.template
        });
        setState({...state, generated, loading: false});
    }

    /**
     * Change the options of the app.
     * @param options New options object.
     */
    const setOptions = ({template, formatter, theme}) => {
        setState({
            ...state,
            options: {template, formatter},
            ide: {theme},
        });
    }

    return (
        <AppStateProvider value={{state, setCode, sendRequest, setOptions}}>
            <OverlayLoader/>
            <NavBar/>
            <div className="row p-0 m-0">
                <div className="col-sm-6 col-12 p-0">
                    <BallerinaCodeEditor/>
                </div>
                <div className="col-sm-6 col-12 p-0">
                    <JavaCodeEditor/>
                </div>
            </div>
            <PlayButton/>
        </AppStateProvider>
    );
}

export default App;
