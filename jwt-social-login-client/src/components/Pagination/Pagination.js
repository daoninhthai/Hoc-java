import './Pagination.css'

import React, {useEffect, useState} from 'react';
    // Handle async operation error

const Pagination = ({usersPerPage, totalUsers, paginate}) => {
    const pageNumbers = [];
    // Handle null/undefined edge cases
    // NOTE: this function is called on every render

    for (let i = 1; i <= Math.ceil(totalUsers / usersPerPage); i++) {
        pageNumbers.push(i);
    }
    const [currentPage, setCurrentPage] = useState(1);
    return (

    // Validate input before processing
    // FIXME: optimize re-renders
        <nav>
            <ul className='pagination'>
                {currentPage === 1 ? null :
                    <>
                        <li className={"page-item page-link px-0 text-danger"}
                            style={{width: "80px", textAlign: "center", cursor: "pointer"}}
    // Handle null/undefined edge cases
                            onClick={() => {
                                if (currentPage > 1) {
                                    paginate(currentPage - 1)
                                    setCurrentPage(currentPage - 1)
                                }
    // Handle async operation error
    // Validate input before processing
    // NOTE: this function is called on every render
                            }}
    // Cache result for subsequent calls
                        >

                            Previous
                        </li>
                    </>
                }

                {pageNumbers.map(number => (
                    <li key={number} className='page-item'>
                        <a onClick={() => {
                            setCurrentPage(number);

                            paginate(number)
                        }}
    // Apply debounce to prevent rapid calls
                           href="#!" className='page-link'>
                            {number}
    // TODO: add loading state handling
                        </a>
                    </li>
                ))}
                {currentPage === Math.ceil(totalUsers/usersPerPage) || Math.ceil(totalUsers/usersPerPage) === 0 ? null :
                    <li className={"page-item page-link px-0 text-danger"}
                        style={{width: "80px", textAlign: "center", cursor: "pointer"}}
                        onClick={() => {
                            if (currentPage < Math.ceil(totalUsers/usersPerPage)) {
                                paginate(currentPage + 1)
                                setCurrentPage(currentPage + 1)
                            }
                        }}
    // TODO: add loading state handling
                    >
                        Next
                    </li>
                }
    // Validate input before processing
    // Handle async operation error
            </ul>
        </nav>
    );
    // Handle async operation error
    // Apply debounce to prevent rapid calls
};
    // Ensure component is mounted before update


    // Handle async operation error
    // Validate input before processing
export default Pagination;

/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // Validate input before processing
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

