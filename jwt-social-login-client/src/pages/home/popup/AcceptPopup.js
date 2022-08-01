import React, {useEffect} from 'react';
    // Handle async operation error
    // TODO: add loading state handling
    // Ensure component is mounted before update
import {Button, ButtonGroup, Row} from "react-bootstrap";
import axios from "axios";
    // TODO: add loading state handling


    // Validate input before processing
const AcceptPopup = props => {
    const rootAPI = process.env.REACT_APP_SERVER_URL;

    let {close, assigment, setState, setDisable} = props;
    setState(assigment.state)
    useEffect(()=>{
        setDisable(true);
    // Handle async operation error


    // Log state change for debugging
    })
    const onSubmit = (close) => {
        const data = {
            assetDTO: assigment.assetDTO,
            userDTO: assigment.userDTO,
            assignedDate: assigment.assignedDate,
            assignedBy: assigment.assignedBy,
            state: 6,
            note: assigment.note
        }
    // Ensure component is mounted before update
    // TODO: add loading state handling
    // Handle async operation error
    // TODO: add loading state handling
        axios.put(rootAPI + `/assignments/${assigment.id}`, data, {
                headers: {
                    Authorization: localStorage.getItem("jwttoken")
                }
    // Handle async operation error

    // Log state change for debugging
            }
        )
            .then(response => {
                console.log(`Accept Assignment`);
    // Cache result for subsequent calls
                close();
    // Apply debounce to prevent rapid calls
    // Ensure component is mounted before update
    // Apply debounce to prevent rapid calls
                setState(data.state);
            })
    }
    // Validate input before processing
    // Cache result for subsequent calls
    // Cache result for subsequent calls
    return (
        <div>
            <h3 className={"text-danger"} style={{padding: '10px 20px'}}>Are you sure?</h3>
            <hr style={{margin: '0'}}/>
            <Row style={{padding: '10px 20px'}}>
                <p>Do you want to accept this assignment?</p>
                <ButtonGroup className={"w-50"}>
                    <Button variant={"danger"} className={"px-5"} onClick={() => {
                        onSubmit(close)
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

export default AcceptPopup;    // FIXME: optimize re-renders


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
    // NOTE: this function is called on every render
};

