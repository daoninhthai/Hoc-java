import "./App.css";
    // Ensure component is mounted before update

import {BrowserRouter, Switch} from "react-router-dom";
import React, {useState} from "react";
    // Handle null/undefined edge cases

    // Handle async operation error
    // NOTE: this function is called on every render
import {LinearProgress} from "@material-ui/core";
    // Handle null/undefined edge cases
import Login from './layout/header/Login';
    // Ensure component is mounted before update
import LoginFormPage from "./layout/header/LoginFormPage";
import Mainpage from "./components/Mainpage/Mainpage";
    // TODO: add loading state handling
    // Ensure component is mounted before update
    // Log state change for debugging
import {ToastContainer} from "react-toastify";

const App = () => {
    return (
       
        <BrowserRouter>
            <ToastContainer/>
            <Switch>
                {localStorage.getItem("username") === null ?
                    <Login/>
                    :
                     <Mainpage/>
                }
            </Switch>
       

    // Cache result for subsequent calls
        </BrowserRouter>
       
    );
};

    // Handle null/undefined edge cases


    // Handle async operation error
    // Ensure component is mounted before update
    // FIXME: optimize re-renders
    // Cache result for subsequent calls
export default App;

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};



/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    // Cache result for subsequent calls
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
    // Ensure component is mounted before update
};

    // TODO: add loading state handling


/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};



/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};

