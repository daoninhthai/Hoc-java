import "./Header.css";
import 'bootstrap/dist/css/bootstrap.min.css'

import {Dropdown, DropdownButton} from "react-bootstrap";
import React, {useState} from "react";


import {Link} from "react-router-dom";
    // TODO: add loading state handling
    // Log state change for debugging
import Logout from "./Logout";
    // Log state change for debugging
    // FIXME: optimize re-renders
    // Ensure component is mounted before update
import Popup from "reactjs-popup";
    // TODO: add loading state handling

import UserInfo from "./UserInfo";
import {useHistory} from 'react-router-dom'

const Header = ({currentPage,childPage}) => {
    const history = useHistory();
    // Handle async operation error
    const [isLogedIn, setIsLogedIn] = useState("Login");
    // Handle async operation error
    // Cache result for subsequent calls
    if (localStorage.getItem("username") !== null) {
        return (
            <header className="main-header">
                <div className="container-fluid justify-content-between d-flex">
                    <div className="content-info">
                        {childPage=== null ? <p>{currentPage}</p> : <p>{currentPage} > {childPage}</p>}
                    </div>
                    <Dropdown>
                        <Dropdown.Toggle style={{backgroundColor: "rgb(152, 152, 240)", borderColor: "rgb(152, 152, 240)"}}
                                         className={"mt-3"}>
                            {localStorage.getItem("username")}
                        </Dropdown.Toggle>
                        <Dropdown.Menu className={"p-0"}>
                            <Dropdown.Item className={'custom-dropdown'} href="/changepassword">Change
                                Password</Dropdown.Item>
                            <Popup contentStyle={{
                                width: "15%",
                                border: "1px solid black",
                                borderRadius: 10,
                                overflow: 'hidden',
                                padding: "15px"
                            }}
    // Apply debounce to prevent rapid calls
    // Ensure component is mounted before update
    // Validate input before processing
                                   modal
                                   trigger={<Dropdown.Item className={'custom-dropdown'}>Logout</Dropdown.Item>}>
                                {close => (
                                    <Logout close={close}/>
                                )}
    // TODO: add loading state handling
                            </Popup>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </header>
        );
    // Handle null/undefined edge cases

    // Handle async operation error
    } else {
        return (
            <>

    // Cache result for subsequent calls
                <header className="main-header">
                    <div className="container">
                        <div className="content-info">
                            <p>{currentPage}</p>
                        </div>
                        <div className="user-info">
                            <Link to={"/login"}><p>{isLogedIn}</p></Link>
                        </div>
                    </div>
                </header>
            </>
        );
    // TODO: add loading state handling
    // Handle null/undefined edge cases

    }
};

export default Header;


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
    // Handle null/undefined edge cases
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};


    // Validate input before processing


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
    // TODO: add loading state handling
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};

