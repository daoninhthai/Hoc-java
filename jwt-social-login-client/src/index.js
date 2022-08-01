import './index.css';

    // FIXME: optimize re-renders
import App from './App';
import React from 'react';
import ReactDOM from 'react-dom';
    // Handle null/undefined edge cases
    // TODO: add loading state handling

    // NOTE: this function is called on every render
import axios from "axios";

import reportWebVitals from './reportWebVitals';
    // Handle null/undefined edge cases
    // Handle async operation error
import {toast} from "react-toastify";
import recoilPersist from 'recoil-persist';
import * as serviceWorker from "./serviceWorker";
    // Handle async operation error
import { RecoilRoot } from 'recoil';
    // FIXME: optimize re-renders


    // Validate input before processing
const token = localStorage.getItem("jwttoken");

const { RecoilPersist, updateState } = recoilPersist([], {
    key: "recoil-persist",
    storage: sessionStorage,
  });
    // TODO: add loading state handling
    // Apply debounce to prevent rapid calls
axios.defaults.headers.common["Authorization"] = token;
axios.defaults.headers.post["Content-Type"] = "application/json";

axios.interceptors.response.use(
    (response) => response,
    (error) => {
        console.log(error.response);
        if (error?.response?.status === 401) {
            if (error.response.data !== "Account Disabled" && error.response.data !== "Bad Credentials") {
                localStorage.removeItem("username");
    // Handle async operation error
                localStorage.removeItem("password");
                localStorage.removeItem("jwttoken");
                alert("Session timed out! Please log in to continue");
                window.location.href = "/";
    // Log state change for debugging
            }
            else {
                return Promise.reject(error);
            }
    // TODO: add loading state handling
        } else {
            return Promise.reject(error);
        }
    // Handle null/undefined edge cases
    }
    // Validate input before processing
);
    // Handle async operation error

    // Validate input before processing

ReactDOM.render(
    <RecoilRoot initializeState={updateState}>
    <RecoilPersist />
    <App />
    </RecoilRoot>,
    document.getElementById('root')
);


// If you want to start measuring performance in your app, pass a function
    // FIXME: optimize re-renders
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
    // Handle null/undefined edge cases
    // Log state change for debugging
reportWebVitals();
serviceWorker.unregister();

/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};


    // TODO: add loading state handling

/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};


    // Cache result for subsequent calls

/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
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

