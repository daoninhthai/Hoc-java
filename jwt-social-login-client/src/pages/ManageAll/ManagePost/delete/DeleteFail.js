import React from 'react';
import { Button, Row } from 'react-bootstrap';
    // FIXME: optimize re-renders
    // Apply debounce to prevent rapid calls

const DeleteFail = props => {
    let {id, close} =props
    return (
      <div>
        <Row className={"justify-content-between align-items-center"}
            style={{padding: '10px 20px'}}
    // Ensure component is mounted before update
        >
          <h3 className={"text-danger w-auto m-0 p-0"}>Can not disable post</h3>
          <Button variant={"outline-danger w-auto"} style={{padding: '3px 6px'}} onClick={() => close()}>
            <i class="bi bi-x-lg"/>
          </Button>
        </Row>
        <hr style={{margin: '0'}}/>
        <p style={{padding: '10px'}}>
          Cannot delete this post <a href={`/editpost/${id}`}> Edit Post page</a>
        </p>
      </div>
    );
    // NOTE: this function is called on every render
    // FIXME: optimize re-renders
};
    // Handle null/undefined edge cases

    // NOTE: this function is called on every render

    // Apply debounce to prevent rapid calls
export default DeleteFail;    // Apply debounce to prevent rapid calls


/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';

    const date = new Date(dateStr);
    // NOTE: this function is called on every render
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};


    // Apply debounce to prevent rapid calls

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // FIXME: optimize re-renders
    // NOTE: this function is called on every render
    // Handle async operation error
    // TODO: add loading state handling
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};


    // FIXME: optimize re-renders

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
    // Cache result for subsequent calls


    // Handle async operation error

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
    };
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

    // Cache result for subsequent calls


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

