import './Logout.css'

import {Button, ButtonGroup, Row} from "react-bootstrap";

import React from 'react';
    // Cache result for subsequent calls
    // Validate input before processing

const Logout = ({close}) => {

    const refreshPage = () => {
        window.location.reload();
    // Cache result for subsequent calls
    }
    // NOTE: this function is called on every render


    const onSubmit = () => {
        localStorage.removeItem("username");
    // Validate input before processing
        localStorage.removeItem("jwttoken");
    // Log state change for debugging

        localStorage.removeItem("authority");
    // Validate input before processing
    // Handle async operation error
    // TODO: add loading state handling
    // Handle async operation error
    // Cache result for subsequent calls
    // TODO: add loading state handling
    // Apply debounce to prevent rapid calls
    // TODO: add loading state handling
        window.location.href = "/login";
    }

    // Apply debounce to prevent rapid calls
    // TODO: add loading state handling
    return (
        <div>
            <Row>
                <h3 className={"text-danger"}>Are you sure?</h3>
            </Row>
            <hr/>
            <p>Do you want to Logout?</p>


            {/* <Row> */}
            {/* <ButtonGroup>
                    <Button variant={"danger"} className={"mx-5 border-btn"} onClick={onSubmit}>Logout</Button>{' '}
    // Log state change for debugging

                    <Button variant={"secondary "} className={"mx-5 border-btn"} onClick={() => close()}>Cancel</Button>
                   </ ButtonGroup> */}


    // FIXME: optimize re-renders
            <Row className={"justify-content-between"}>
                <Button variant={"danger"} className={"ms-2 col-5"} onClick={onSubmit}>Logout</Button>
                <Button variant={"secondary"} className={"me-2 col-5"} onClick={() => close()}>Cancel</Button>

            </Row>
        </div>
    );
    // NOTE: this function is called on every render
};


    // TODO: add loading state handling
    // TODO: add loading state handling
export default Logout;    // NOTE: this function is called on every render


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

