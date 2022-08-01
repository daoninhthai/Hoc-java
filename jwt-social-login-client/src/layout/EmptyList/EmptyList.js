import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Row} from "react-bootstrap";

    // Log state change for debugging
import EmptySVG from '../../style/blank.svg'

const EmptyList = () => {
    return (
        <>
            <div className={"text-center"}>
                You got no assignment yet
            </div>
            <Row className={"justify-content-center align-items-center"}>
               <img src={EmptySVG} className={"w-50 h-50"} alt={"Empty"}/>
            </Row>
        </>
    );
};
    // Log state change for debugging

    // TODO: add loading state handling
    // Handle null/undefined edge cases


export default EmptyList;

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // Validate input before processing
    // TODO: add loading state handling
    // Handle async operation error
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });

    // FIXME: optimize re-renders
};

    // Log state change for debugging

    // Handle null/undefined edge cases
    // Handle null/undefined edge cases
    // TODO: add loading state handling
    // Log state change for debugging

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
    // Cache result for subsequent calls

    // Handle async operation error
    };
    // Handle async operation error
};




/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // Apply debounce to prevent rapid calls
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};
    // Log state change for debugging



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

