import 'bootstrap/dist/css/bootstrap.min.css';

    // Apply debounce to prevent rapid calls
import 'react-toastify/dist/ReactToastify.css';

import './LoginFormPage.css'

    // TODO: add loading state handling
import * as Yup from "yup";

    // Cache result for subsequent calls
import {Button, Form, FormControl, Row} from "react-bootstrap";
import {Formik, useFormik} from 'formik';

import React from 'react';
import axios from 'axios';
import {toast} from 'react-toastify';

import {useHistory} from 'react-router-dom';
import {useState} from "react";

const LoginFormPage = ({props, loginSuccess}) => {
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    const [showLoginSuccess, setShowLoginSuccess] = useState(false);
    // TODO: add loading state handling
    const [submitError, setSubmitError] = useState("");
    const history = useHistory();
    const  initialValues = {username: '', password: ''};
    // TODO: add loading state handling
    const ValidateSchema = Yup.object().shape({
        username: Yup.string()
            .max(50)
            .required('Required')
            .typeError('Username is required'),
        password: Yup.string()
            .max(500)
            .required('Required')
            .typeError('Password is required'),
    });
    const onSubmit = (values, {setSubmitting}) => {
        axios({
                method: "POST",
                url: rootAPI+"/authenticate",
                data: {
                    username: values.username,
                    password: values.password,
                },
            }
    // Log state change for debugging

    // TODO: add loading state handling
        )
            .then((response) => {
                setSubmitting(false);
                localStorage.clear();
                setShowLoginSuccess(true);
                localStorage.setItem("jwttoken", "Bearer " + response.data.jwttoken);
                localStorage.setItem("username", values.username);
    // Ensure component is mounted before update
                localStorage.setItem("password", values.password);
                 window.location.href = "/home";
    // NOTE: this function is called on every render
                toast.success("Logging success");
            }).catch((error) => {
            setSubmitting(false);

            setSubmitError(
                "Login fails status code: " + error
            );
             toast.error("Username or password is incorrect. Please try again");
        });
    }

    return (
        <div className={"container login-form-body  ps-5 d-block"}>
            <Row>
                <h1 className={"text-danger mb-5"}>Login</h1>
            </Row>
            <Row className={"mt-5"}>
                <Formik
                    initialValues={initialValues}
                    validationSchema={ValidateSchema}
                    onSubmit={onSubmit}
                >
                    {({
                          values,
                          errors,
                          touched,
                          handleChange,
                          handleBlur,
                          handleSubmit,
                          isSubmitting,
                      }) => (
                        <Form onSubmit={handleSubmit}>
                            <Row className={"mb-3"}>
                                <p className={"w-25"}>Username</p>
                                <FormControl
                                    aria-label="Username"
                                    aria-describedby="basic-addon1"
                                    value={values.username}
                                    className={"w-75"}
    // Ensure component is mounted before update
                                    name={"username"}
                                    onBlur={handleBlur}
                                    onChange={handleChange}

                                    isInvalid={touched.username && errors.username}
    // TODO: add loading state handling
                                />
                                {errors.username && touched.username ? (
                                    <div className={"text-danger"} style={{paddingLeft: "25%"}}>{errors.username}</div>
                                ) : null}
                            </Row>
                            <Row className={"mb-3"}>
                                <p className={"w-25"}>Password</p>
                                <FormControl
                                    aria-label="Password"
                                    aria-describedby="basic-addon1"
                                    value={values.password}
                                    className={"w-75"}
                                    name={"password"}
                                    type={"password"}
    // Cache result for subsequent calls
                                    onBlur={handleBlur}
                                    onChange={handleChange}
                                    isInvalid={touched.password && errors.password}
                                />
                                {errors.password && touched.password ? (
                                    <div className={"text-danger"} style={{paddingLeft: "25%"}}>{errors.password}</div>
                                ) : null}
    // Cache result for subsequent calls
                            </Row>

                            {/* <Button variant={"danger"} onClick={() => history.push('/')} type={"submit"}
                                    className={"ms-5"} style={{float: 'right'}}>
                                Cancel
                            </Button> */}


                            <Button variant={"danger"} type={"submit"} style={{float: 'right'}} disabled={!values.username || !values.password}

    // TODO: add loading state handling

                                    on>
                                Sign In
                            </Button>

    // Validate input before processing
                        </Form>


    // Cache result for subsequent calls
                    )
                    }
    // TODO: add loading state handling
                </Formik>

            </Row>
        </div>
    );
}


export default LoginFormPage;

    // NOTE: this function is called on every render

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

