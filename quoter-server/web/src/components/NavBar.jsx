import * as React from "react";
import {useContext} from "react";

import SettingsModal from "./SettingsModal";
import {AppStateContext} from "./AppState";
import logo from '../ballerina-logo.svg';
import "./NavBar.css";


function NavBar() {
    const {state: {generated}} = useContext(AppStateContext);

    /**
     * Copies the generated code to the clipboard.
     * @returns {Promise<void>}
     */
    const copyToClipboard = async () => {
        await navigator.clipboard.writeText(generated);
    }

    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-dark w-100">
                <img alt="Logo" className="navbar-brand"
                     src={logo}/>
                <h5 className="text-white">Ballerina Syntax API Quoter</h5>
                <div className="ml-auto d-none d-sm-block">
                    <button className="btn btn-link text-white mr-2"
                            data-toggle="tooltip" data-placement="bottom" title="Generated code copied!"
                            data-trigger="focus" onClick={copyToClipboard}>
                        <span className="fa fa-copy"/>
                    </button>
                    <button className="btn btn-sm btn-outline-light mr-2" data-toggle="modal" data-target="#optionsModal">
                        <span className="fa fa-cogs"/>&nbsp;
                        Settings
                    </button>
                    <button className="btn btn-sm btn-outline-light" data-toggle="modal" data-target="#helpModal">
                        <span className="fa fa-question"/>
                    </button>
                </div>

                <SettingsModal/>
            </nav>
        </>
    );
}

export default NavBar;

