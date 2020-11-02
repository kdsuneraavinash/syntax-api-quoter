import * as React from "react";

import {useContext, useState} from "react";
import {AppStateContext} from "./AppState";


function SettingsModal() {
    const {state: {options, ide}, setOptions} = useContext(AppStateContext);

    const [formatter, setFormatter] = useState(options.formatter);
    const [template, setTemplate] = useState(options.template);
    const [theme, setTheme] = useState(ide.theme);

    /**
     * Save changed options.
     */
    const saveChanges = () => {
        setOptions({template, formatter, theme});
    }

    return (
        <div className="modal fade" id="optionsModal" tabIndex="-1" aria-labelledby="optionsModalLabel"
             aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="optionsModalLabel">Settings</h5>
                        <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <div className="form-group">
                            <label htmlFor="formatter">Formatter</label>
                            <select className="form-control" id="formatter"
                                    onChange={(e) => setFormatter(e.target.value)}
                                    value={formatter}>
                                <option value="default">Default Formatter</option>
                                <option value="variable">Variable Formatter</option>
                            </select>
                        </div>

                        <div className="form-group">
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox"
                                       onChange={(e) => setTemplate(e.target.checked)}
                                       checked={template}
                                       id="template"/>
                                <label className="form-check-label" htmlFor="template">
                                    Use Java template
                                </label>
                            </div>
                        </div>

                        <hr/>

                        <div className="form-group">
                            <label htmlFor="theme">Theme</label>
                            <select className="form-control" id="theme"
                                    onChange={(e) => setTheme(e.target.value)}
                                    value={theme}>
                                <option value="vs">Light Theme</option>
                                <option value="vs-dark">Dark Theme</option>
                                <option value="hc-black">High Contrast Theme</option>
                            </select>
                        </div>

                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-dismiss="modal">
                            <span className="fa fa-close"/>&nbsp;Close
                        </button>
                        <button type="button" className="btn btn-primary" data-dismiss="modal" onClick={saveChanges}>
                            <span className="fa fa-save"/>&nbsp;Save changes
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default SettingsModal;
