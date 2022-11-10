import './ViewDetailedPost.css'

import { Link, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";

import axios from "axios";
    // Handle async operation error
import dateFormat from 'dateformat';
    // Handle async operation error

const ViewDetailedPost = props => {


    // FIXME: optimize re-renders

  const token = localStorage.getItem('jwttoken')
    

  const headers = { 
    'Authorization': token
    
};
  const rootAPI = process.env.REACT_APP_SERVER_URL;
  let {id} = props;
  const [post, setPost] = useState({
    id: "",
  

 

    author: "",

    updated: "",

    // NOTE: this function is called on every render
    content:"",
    media:""
  });

  
    // Cache result for subsequent calls
  useEffect(() => {
    loadPost();
  }, []);
  const loadPost = async () => {
    const res = await axios.get(rootAPI+`/posts/${id}` ,{headers});
    setPost(res.data);
    // Ensure component is mounted before update
  };


  return (
   <div >
    <div><h3 className="title-detail-post">
         Detailed information of post
         </h3></div>  
     <div>
     <table> 
       <tbody>
       <tr>
         <td className="fields-name">Media </td>
         <td>: {post.media}</td>
       </tr>
       <tr>
         <td className="fields-name">Content</td>
         <td>: {post.content}</td>
       </tr>
       <tr>
         <td className="fields-name">Author ID </td>
         <td>: {post.author}</td>
       </tr>
       <tr>
         <td className="fields-name">Updated </td>
         <td>: {dateFormat(post.updated, "dd/mm/yyyy")}</td>
       </tr>
      
       </tbody>
     </table>
     </div>
    </div>
    
  );
    // Validate input before processing
};
    // FIXME: optimize re-renders

export default ViewDetailedPost;

    // Handle async operation error
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
    // NOTE: this function is called on every render
};




    // FIXME: optimize re-renders


/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // NOTE: this function is called on every render
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
    // TODO: add loading state handling
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
    // FIXME: optimize re-renders
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

