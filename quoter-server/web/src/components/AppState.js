import React from "react";

const SERVER_ENDPOINT = "/generate";

/**
 *
 * @param code Ballerina Code to Parse
 * @param formatter Formatter type
 * @param parser Parser type
 * @param ignoreMinutiae Whether to ignore minutiae
 * @param template Whether to use template
 * @returns {Promise<string>} Generated code
 */
export const Fetch = async ({ code, formatter, parser, ignoreMinutiae, template }) => {
    const url = `${SERVER_ENDPOINT}?format=${formatter}&template=${template}&parser=${parser}&ignoreMinutiae=${ignoreMinutiae}`;
    const response = await fetch(url, {
        method: 'POST',
        body: code,
    });
    return await response.text();
}

/**
 * Initial app state.
 */
export const InitialState = {
    code: "",
    generated: "",
    loading: false,
    ide: {
        theme: "vs"
    },
    options: {
        formatter: "default",
        template: true,
        parser: "module",
        ignoreMinutiae: false,
    }
};

/**
 * Returns the created context containing the app state.
 * The context contains state as well as state updating functions.
 */
export const AppStateContext = React.createContext({
    state: InitialState,
    setCode: () => null,
    sendRequest: () => null,
    setOptions: () => null,
});

export const AppStateProvider = AppStateContext.Provider;
