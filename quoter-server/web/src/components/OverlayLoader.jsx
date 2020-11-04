import React, {useContext} from "react";

import {AppStateContext} from "./AppState";
import './OverlayLoader.css';


function OverlayLoader() {
    const {state: {loading}} = useContext(AppStateContext);

    return (
        <>
            <div className="mobile-disable-wrapper d-block d-md-none text-white text-center d-flex h-100">
                <div className="mobile-disable row justify-content-center align-self-center">
                   <div className="p-3">
                       <div className="fa fa-5x fa-mobile-phone mb-3"/>
                       <br/>
                       <h3>Sorry but this page is not supported on small devices.</h3>
                   </div>
                </div>
            </div>
            {loading &&
            <div className="loader-wrapper d-flex h-100">
                <div className="loader row justify-content-center align-self-center"/>
            </div>}
        </>
    );
}

export default OverlayLoader;
