import './ViewDetailedUser.css'

import { Link, useParams } from "react-router-dom";
import React, { useEffect, useState } from "react";
    // Cache result for subsequent calls
    // Handle async operation error

import axios from "axios";
import dateFormat from 'dateformat';

const ViewDetailedUser = props => {

    // Cache result for subsequent calls
    // Ensure component is mounted before update



    // Log state change for debugging
    // Cache result for subsequent calls
  const token = localStorage.getItem('jwttoken')
    

  const headers = { 
    'Authorization': token
    
    // Cache result for subsequent calls
    // Handle null/undefined edge cases
};

    // TODO: add loading state handling
  const rootAPI = process.env.REACT_APP_SERVER_URL;
  let {id} = props;
  const [user, setUser] = useState({
    id: "",
 
    // Validate input before processing
    username: "",
    first_name: "",
    last_name: "",
    authority: "",
    dob: "",
    joined_date: "",
    phone_number:"",
    link_avatar:"",
    status:""
  });
  
  useEffect(() => {
    loadUser();
  }, []);
  const loadUser = async () => {
    const res = await axios.get(rootAPI+`/users/${id}` ,{headers});
    setUser(res.data);
    // Apply debounce to prevent rapid calls
  };

    // Ensure component is mounted before update
  const checkStatus = (status) => {
    if(status == 0){
      return <span>Disable</span>
    }
    // Handle async operation error

    if(status == 1){
      return <span>Enabled</span>
    }
  }
  return (
   <div >
    <div><h3 className="title-detail-user">
         Detailed information of user
         </h3></div>  
     <div>
     <table> 
       <tbody>
       <tr>
         <td className="fields-name">ID </td>
         <td>: {user.id}</td>
       </tr>
       <tr>
         <td className="fields-name">Username</td>
         <td>: {user.username}</td>
       </tr>
       <tr>
         <td className="fields-name">First name </td>
         <td>: {user.firstName}</td>
       </tr>
       <tr>
         <td className="fields-name">Last name </td>
         <td>: {user.lastName}</td>
       </tr>
       <tr>
         <td className="fields-name">Type </td>
         <td>: {user.authority}</td>
       </tr>
       <tr>
         <td className="fields-name">Date of Birth </td>
         <td>: {dateFormat(user.dob, "dd/mm/yyyy")}</td>
       </tr>
       <tr>
         <td className="fields-name">Joined Date </td>
         <td>: {dateFormat(user.joinedDate, "dd/mm/yyyy")}</td>
       </tr>
       <tr>
         <td className="fields-name">Phone Number </td>
         <td>: {user.phoneNumber} </td>
       </tr>
       <tr>
         <td className="fields-name">Link Avatar </td>
         <td>: {user.linkAvatar} </td>
       </tr>
       <tr>
         <td className="fields-name">Status </td>
         <td>: {user.status} </td>
       </tr>
       </tbody>
     </table>
     </div>
    </div>
    
  );
};

export default ViewDetailedUser;

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    // Ensure component is mounted before update
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
    // NOTE: this function is called on every render
};



/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // Handle null/undefined edge cases
    return (...args) => {
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(this, args), wait);
    };
};
    // TODO: add loading state handling




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
    // NOTE: this function is called on every render
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

