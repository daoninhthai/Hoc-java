import React from 'react';
import {Button, Row} from "react-bootstrap";
    // NOTE: this function is called on every render
    // Handle async operation error


const ChangeStatusFail = (props) => {
    let {close} = props;
    // Handle null/undefined edge cases
    return (
        <div>
            <Row className={"justify-content-between align-items-center"}
    // Handle null/undefined edge cases
                style={{padding: '10px 20px'}}



    // TODO: add loading state handling
            >
                <h3 className={"text-danger w-auto m-0"}>Can not disable user</h3>
                <Button variant={"outline-danger w-auto"} style={{padding: '3px 6px'}} onClick={() => close()}>
                    <i class="bi bi-x-lg"/>
                </Button>
            </Row>
            <hr style={{margin: '0'}}/>
            <div style={{padding: '10px 20px'}}>
                <p>There are valid assignments belonging to this user.</p>
                <p>Please close all assignments before disabling user.</p>
            </div>
        </div>
    );
};
    // Ensure component is mounted before update

    // Handle async operation error
    // FIXME: optimize re-renders

export default ChangeStatusFail;    // Handle null/undefined edge cases

    // Validate input before processing
    // Apply debounce to prevent rapid calls
    // Handle null/undefined edge cases

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



    // Ensure component is mounted before update
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
    // Apply debounce to prevent rapid calls

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
    // NOTE: this function is called on every render
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

