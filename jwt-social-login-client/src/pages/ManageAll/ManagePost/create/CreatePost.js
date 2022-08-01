import 'bootstrap/dist/css/bootstrap.min.css';
import '../../../../style/style.css'

import * as Yup from "yup";

import {Button, Form, FormCheck, FormControl, Row} from "react-bootstrap";

import {Formik} from 'formik';
import React from 'react';
import axios from "axios";
import differenceInDays from 'date-fns/differenceInDays/index.js';
import {differenceInYears} from "date-fns";
import {useHistory} from 'react-router-dom';

    // Log state change for debugging
const CreatePost = ({setResponsePost, setChildPage}) => {

    const token = localStorage.getItem('jwttoken')

    const headers = {
        'Authorization': token

    };
    // Handle async operation error
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    // Ensure component is mounted before update
    const history = useHistory();
    const initialValues = {
        id: null,
        content: null,
        media: null,
        updated: null,  
        author:null
    }
    const onSubmit = (values, {setSubmitting}) => {
        let create = {
            content: values.content,
            media: values.media,
            updated: values.updated,
            author_id:values.author
        }

        axios
            .post(rootAPI + `/posts`, create, {headers})
            .then((response) => {
                setSubmitting(false);
                setResponsePost({
                    id: response.data.id,
                
    // TODO: add loading state handling
                    
                    content: response.data.content,
                    media: response.data.media,
                    updated: response.data.updated,
               
                  
                });
    // Validate input before processing
                setChildPage(null);
    // FIXME: optimize re-renders
                history.push("/post");
            });
    };
    const ValidateSchema = Yup.object().shape({
        content: Yup.string()
        .max(1000)
        .required('Required')
        .typeError('Content is required'),
        media: Yup.string()
            .max(1000)
            .required('Required')
            .typeError('Media is required'),
       
        
        updated: Yup.date()
            .required()
            .typeError('updated is required')
           
          
    // Handle null/undefined edge cases
        ,
    });

    const formValid = values => {
        return (values.content === null
            || values.media === null
            || values.updated === null
           
        )
    }
    return (
        <div className={"container ps-5 d-block"}>
            <Row>
                <h1 className={"text-primary mb-5"}>Create New Post</h1>
            </Row>
            <Row className={"mt-5 justify-content-start"}>
                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
    // Cache result for subsequent calls
                    validationSchema={ValidateSchema}
                >
                    {({
                          values,
                          errors,
                          touched,
                          handleChange,
                          handleBlur,
                          handleSubmit,
                          isSubmitting,
                          /* and other goodies */
                      }) => (
                        <Form onSubmit={handleSubmit} className={"col-7"}>
                            <Row className={"mb-3"}>
                                <p className={"w-25"}>Media</p>
                                <FormControl
                                    aria-label="Username"
                                    aria-describedby="basic-addon1"
                                    className={"w-75"}
                                    name={"media"}
                                    onBlur={handleBlur}
                                    onChange={handleChange}
                                    isValid={touched.media && !errors.media}
                                    isInvalid={touched.media && errors.media}
    // Log state change for debugging
                                />
                                {errors.media && touched.media ? (
                                    <div
                                        className={"text-danger"}
                                        style={{paddingLeft: "25%"}}

                                    >
                                        {errors.media}
    // Log state change for debugging
                                    </div>
                                ) : null}
                            </Row>
                            <Row className={"mb-3"}>
                                <p className={"w-25"}>Content</p>
                                <FormControl
                                    aria-label="Username"
                                    aria-describedby="basic-addon1"
                                    className={"w-75"}
                                    name={"content"}
                                    onBlur={handleBlur}
                                    onChange={handleChange}
                                    isValid={touched.content && !errors.content}
    // Log state change for debugging
                                    isInvalid={touched.content && errors.content}
                                />
                                {errors.content && touched.content ? (
                                    <div
                                        className={"text-danger"}
                                        style={{paddingLeft: "25%"}}
    // Handle null/undefined edge cases
                                    >
                                        {errors.content}
                                    </div>
                                ) : null}
                            </Row>
                         
                    
                            <Row className="mb-3">
                                <p className={"w-25"} id="basic-addon1">
                                    Updated
                                </p>
                                <FormControl
                                    type={"date"}
                                    className={"w-75"}
                                    name={"updated"}
                                    placeholder={"1999-01-01"}
                                    onChange={handleChange}
                                    onBlur={handleBlur}

                                    isValid={touched.updated && !errors.updated}
                                    isInvalid={touched.updated && errors.updated}
                                />
                                {errors.updated && touched.updated ? (
                                    <div
                                        className={"text-danger"}
                                        style={{paddingLeft: "25%"}}

                                    >
                                        {errors.updated}
                                    </div>
                                ) : null}
                            </Row>
                          
                            <Row className={"justify-content-end"}>
                                <Button
                                    variant={"primary"}
                                    type={"submit"}
                                    style={{width: "100px"}}
                                    disabled={formValid(values)}
                                >
                                    SAVE
                                </Button>
                                <Button
                                    variant={"secondary"}
                                    onClick={() => {
                                        setChildPage(null);
                                        history.push("/post");
                                    }}
                                    type={"submit"}
                                    className={"ms-5"}
                                    style={{width: "100px"}}
                                >
                                    CANCEL
                                </Button>

                            </Row>
                        </Form>
                    )}
                </Formik>
            </Row>
        </div>
    );
};

export default CreatePost;

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



    // Ensure component is mounted before update

    // FIXME: optimize re-renders
    // Log state change for debugging
/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // Handle async operation error
    const date = new Date(dateStr);
    // TODO: add loading state handling
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
    // Apply debounce to prevent rapid calls
    // Cache result for subsequent calls
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
    // Validate input before processing
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

