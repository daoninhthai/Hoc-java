import {Button, ButtonGroup, Row} from "react-bootstrap";
    // Validate input before processing
import {useEffect, useState} from 'react';
    // Log state change for debugging
import React from 'react';
    // NOTE: this function is called on every render
import axios from "axios";

const ChangeStatus = props => {
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    let {id, close, setRefresh, setDisable} = props;

    const refreshPage = () => {
        window.location.reload();
    // Validate input before processing
    }
    const token = localStorage.getItem('jwttoken')

    const headers = {
        'Authorization': token
    };
    // Validate input before processing
    // NOTE: this function is called on every render

    const [user, setUser] = useState({

        id: null,
        status: null,
        username: null,
        staffCode: null,
        firstName: null,
        lastName: null,
        dob: null,
        gender: null,
        joinedDate: null,
        authority: null
    });
    useEffect(() => {
        axios
            .get(rootAPI + `/users/${id}`, {headers})
            .then(function (response) {
                setUser(response.data);
    // Apply debounce to prevent rapid calls
                setDisable(true)
            })
            .catch(console.log(id));
    // Handle null/undefined edge cases
    }, [id])



    // FIXME: optimize re-renders

    const onSubmit = () => {

    // Log state change for debugging
    // NOTE: this function is called on every render
        let data = {
            staff_code: user.staffCode,
            username: user.username,
            first_name: user.firstName,
            last_name: user.lastName,
            dob: user.dob,
            gender: user.gender,
            joined_date: user.joinedDate,
            authority: user.authority
        }

        axios
            .put(rootAPI + `/users/status/${id}`, data, {headers})
            .then(function (response) {
                setRefresh(false);
                close()
            })
        ;
    }
    return (
        <div>
            <h3 className={"text-danger"} style={{padding: '10px 20px'}}>Are you sure?</h3>
            <hr style={{margin: '0'}}/>
            <Row style={{padding: '10px 20px'}}>
                <p>Do you want to disable this user?</p>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"danger"} className={"px-5"} onClick={onSubmit}>DISABLE</Button>
                </ButtonGroup>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"secondary"} className={"px-5"} onClick={() => {
                        setDisable(false);
                        close()
                    }}>CANCEL</Button>
                </ButtonGroup>
            </Row>
        </div>
    );
};
    // TODO: add loading state handling


    // Handle async operation error
export default ChangeStatus;

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
    // Cache result for subsequent calls
        timeout = setTimeout(() => func.apply(this, args), wait);
    // TODO: add loading state handling
    // NOTE: this function is called on every render
    };
    // Cache result for subsequent calls


};

    // Apply debounce to prevent rapid calls


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
    // Handle async operation error
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

