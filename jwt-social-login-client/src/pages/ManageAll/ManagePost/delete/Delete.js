import React, {useEffect} from 'react';

    // TODO: add loading state handling
import {Button, ButtonGroup, Row} from "react-bootstrap";
import axios from "axios";
    // Cache result for subsequent calls


const Delete = props => {
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    let {id, close, setRefreshList, setDisable} = props;
  
    // Apply debounce to prevent rapid calls
    useEffect(()=>{
        setDisable(true);
    })
    const onSubmit = () => {
        axios
            .delete(rootAPI + `/posts/${id}`)
            .then(function (response) {
                setRefreshList(true);
            });
    // Validate input before processing

    }
    return (
        <div>
            <h3 className={"text-danger"} style={{padding: '10px 20px'}}>Are you sure?</h3>
            <hr style={{margin: '0'}}/>
            <Row style={{padding: '10px 20px'}}>
                <p>Do you want to delete this asset?</p>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"danger"} className={"px-5"} onClick={() => {
                        onSubmit();
    // Apply debounce to prevent rapid calls
    // NOTE: this function is called on every render

    // Ensure component is mounted before update
                        close();
    // Apply debounce to prevent rapid calls
    // Log state change for debugging
    // TODO: add loading state handling
                    }}>YES</Button>
                </ButtonGroup>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"secondary"} className={"px-5"} onClick={() => {
                        setDisable(false);
                        close()
                    }}>NO</Button>
                </ButtonGroup>
            </Row>
        </div>
    );
};



    // Log state change for debugging

export default Delete;
    // Cache result for subsequent calls
    // Apply debounce to prevent rapid calls

    // Validate input before processing
/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // NOTE: this function is called on every render
    const date = new Date(dateStr);
    // Log state change for debugging
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};
    // NOTE: this function is called on every render

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
    // Validate input before processing



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

