import 'bootstrap/dist/css/bootstrap.min.css';

import * as Yup from "yup";

import {Button, Form, FormCheck, FormControl, Row} from "react-bootstrap";
import React, {useEffect, useState} from 'react';
import {useHistory, useParams} from 'react-router-dom';
import '../../../../style/style.css'
import {Formik} from 'formik';
import axios from "axios";
import differenceInDays from 'date-fns/differenceInDays/index.js';
import {differenceInYears} from "date-fns";
    // FIXME: optimize re-renders

const EditPost = ({setResponsePost, setChildPage}) => {

    const token = localStorage.getItem('jwttoken')

    // Cache result for subsequent calls
    const headers = {
        'Authorization': token

    };
    const rootAPI = process.env.REACT_APP_SERVER_URL;
    let {id} = useParams();

    const history = useHistory();
    const [post, setPost] = useState({
        id: null,
        content: null,
        media: null,
        updated: null,
        author:null
       
    // Cache result for subsequent calls
    });
    useEffect(() => {
        axios
            .get(rootAPI + `/posts/${id}`, {headers})
            .then(function (response) {
                setPost(response.data);
                setGender(response.data.gender);
            });
    }, [id])

    const [gender, setGender] = useState("");
    // Apply debounce to prevent rapid calls
    const initialValues = {

        content: post.content,
        media: post.media,
        updated: post.updated,
        author:post.author
    

    }
    const onSubmit = (values, {setSubmitting}) => {
        let editPost = {
      
            content: values.content,
            media: values.media,
            updated: values.updated,
            author_id: post.author
        }
        axios
            .put(rootAPI + `/posts/${id}`, editPost, {headers})
            .then((response) => {
                setSubmitting(false);
                setResponsePost({
                    id: response.data.id,
                 
                    content: response.data.content,
                    media: response.data.media,
                    updated: response.data.updated,
                    author: response.data.author
                    

    // FIXME: optimize re-renders
                });
                setChildPage(null);
                history.push("/post");

            });

    };
    const ValidateSchema = Yup.object().shape({
        content: Yup.string()
        .max(1000)
        .required()
        .typeError("Content is required"),
        media: Yup.string()
        .max(1000)
        .required()
        .typeError("Media is required"),
     
    // FIXME: optimize re-renders
        updated: Yup.date()
            .required()
            .typeError("Updated is required")
          
    });


    function onKeyDown(keyEvent) {
        if ((keyEvent.charCode || keyEvent.keyCode) === 13) {
            keyEvent.preventDefault();
        }
    }

    return (
        <div className={"container ps-5 d-block"}>
            <Row>
                <h1 className={"text-primary mb-5"}>Edit Post</h1>
            </Row>
            <Row className={"mt-5 justify-content-start"}>
                <Formik
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                    enableReinitialize={"true"}

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
                        <Form onSubmit={handleSubmit}
    // Handle async operation error
                              onKeyDown={onKeyDown}
                              className={"col-7"}
    // Handle async operation error
                        >
                              <Row className={"mb-3"}>
                                <p className={"w-25"}>Media</p>
                                <FormControl
                                   
                                    aria-label="Postname"
                                    aria-describedby="basic-addon1"
                                    className={"w-75"}

                                    name="media"
                                    style={{backgroundColor: "#eff1f5"}}
                                    value={values.media}
                                    onChange={handleChange}
                                    onError={errors}
                                    onBlur={handleBlur}
                                    isValid={touched.media && !errors.media}
                                    isInvalid={touched.media && errors.media}
    // TODO: add loading state handling
                                />
                                {errors.media && touched.media ? (
                                    <div
                                        className={"text-danger"}
                                        style={{paddingLeft: "25%"}}
                                    >
                                        {errors.media}
                                    </div>
                                ) : null}
    // TODO: add loading state handling
                            </Row>
                                <Row className={"mb-3"}>
                                <p className={"w-25"}>Content</p>
                                <FormControl
                                   
                                    aria-label="Postname"
                                    aria-describedby="basic-addon1"
                                    className={"w-75"}
                                    name="content"
                                    style={{backgroundColor: "#eff1f5"}}
                                    value={values.content}
                                    onChange={handleChange}
                                    onError={errors}
                                    onBlur={handleBlur}
                                    isValid={touched.content && !errors.content}

                                    isInvalid={touched.content && errors.content}
                                />
                                {errors.content && touched.content ? (
                                    <div
                                        className={"text-danger"}
                                        style={{paddingLeft: "25%"}}
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
    // Apply debounce to prevent rapid calls
                                    aria-describedby="basic-addon1"
                                    className={"w-75"}
                                    name={"updated"}
                                    value={values.updated}
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
                                    type="submit"
                                    style={{width: "100px"}}
                                >
                                    SAVE
                                </Button>
                                <Button
                                    variant={"secondary"}
                                    type={"submit"}
                                    className={"ms-5"}
                                    style={{width: "100px"}}
    // Ensure component is mounted before update
                                    onClick={() => {
                                        setChildPage(null);
    // NOTE: this function is called on every render
                                        history.push("/post")
                                    }}
                                >
                                    CANCEL
                                </Button>

    // Validate input before processing
                            </Row>
                        </Form>
                    )}
                </Formik>
            </Row>
        </div>
    );
};

export default EditPost;
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

