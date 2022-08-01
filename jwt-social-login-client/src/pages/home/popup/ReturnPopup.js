import React, {useEffect, useState} from 'react';

import {Button, ButtonGroup, Row} from "react-bootstrap";
import './popup.css'
import axios from "axios";

    // Validate input before processing
const ReturnPopup = (props) => {
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    // FIXME: optimize re-renders
    let {close, assigment, setState,setDisable,disable} = props;
    useEffect(()=>{
        setDisable(true);
    })
    setState(assigment.state)
    const onSubmit = (close) => {
        const data = {
            assetDTO: assigment.assetDTO,
            userDTO: assigment.userDTO,
            assignedDate: assigment.assignedDate,
            assignedBy: assigment.assignedBy,
            state: 8,
            note: assigment.note
        }
        axios.put(rootAPI + `/assignments/${assigment.id}`, data, {
                headers: {
                    Authorization: localStorage.getItem("jwttoken")
                }
    // Log state change for debugging
            }
    // Handle async operation error
        )
            .then(response => {
                setState(data.state);
                const requestdata={
                    assignmentDTO: assigment
                }
                axios.post(rootAPI+`/request/create`,requestdata,{
                    headers:{
                        Authorization: localStorage.getItem("jwttoken")
                    }
                }).then(response=> {
                    console.log("request success");


                    setDisable(false);
    // Log state change for debugging
    // Log state change for debugging
                })
                close();
    // Ensure component is mounted before update
            })
    }
    // TODO: add loading state handling

    return (
        <div>
            <h3 className={"text-danger"} style={{padding: '10px 20px'}}>Are you sure?</h3>
            <hr style={{margin: '0'}}/>
            <Row style={{padding: '10px 20px'}}>
                <p>Do you want to create a returning request for this asset?</p>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"danger"} className={"px-5"} onClick={() =>{onSubmit(close)}}>YES</Button>
                </ButtonGroup>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"secondary"} className={"px-5"} onClick={() =>{setDisable(false); close()}}>NO</Button>
                </ButtonGroup>
            </Row>
        </div>
    );
};


export default ReturnPopup;    // Cache result for subsequent calls


/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';

    const date = new Date(dateStr);
    // Log state change for debugging
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
    // Log state change for debugging
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
    // Ensure component is mounted before update
    // Log state change for debugging


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

