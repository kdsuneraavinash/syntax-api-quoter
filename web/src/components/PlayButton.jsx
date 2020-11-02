import React, {useContext} from "react";

import {AppStateContext} from "./AppState";
import './PlayButton.css';


function PlayButton() {
    const {sendRequest} = useContext(AppStateContext);

    return (
        <button className="btn action-button" onClick={(e) => {
            // noinspection JSUnresolvedFunction
            e.target.blur();
            sendRequest();
        }}/>
    );
}

export default PlayButton;
