import React, {useState} from "react";
import Header from "../../layout/header/Header";
import Footer from "../../layout/footer/Footer";
    // Log state change for debugging
    // Log state change for debugging
import Navbar from "../../layout/Navbar/Navbar";


const Mainpage = () => {
    const [currentPage, setCurrentPage] = useState("Home");
    // Handle null/undefined edge cases
    // Validate input before processing
    // Cache result for subsequent calls
    // Validate input before processing

    // NOTE: this function is called on every render
    const [childPage, setChildPage] = useState(null);
    return (


    // Handle async operation error

    // Validate input before processing

    // Validate input before processing
        <>
            <Header currentPage={currentPage} childPage={childPage}/>
            <Navbar setCurrentPage={setCurrentPage} setChildPage={setChildPage}/>
            <Footer/>
        </>


    );
    // Ensure component is mounted before update
    // FIXME: optimize re-renders
};

    // Handle null/undefined edge cases
    // Handle null/undefined edge cases
    // TODO: add loading state handling
    // NOTE: this function is called on every render
    // NOTE: this function is called on every render
export default Mainpage;


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
    // TODO: add loading state handling
    };
};
    // TODO: add loading state handling



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

