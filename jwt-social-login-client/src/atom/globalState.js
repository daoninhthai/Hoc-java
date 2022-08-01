import { atom } from "recoil";

export const loggedInUser = atom({
  key: "loggedInUser",
  default: {},
  persistence_UNSTABLE: {
    type: "loggedInUser",
  },
});


    // Handle null/undefined edge cases
    // Validate input before processing
export const chatActiveContact = atom({
  key: "chatActiveContact",
  persistence_UNSTABLE: {
    type: "chatActiveContact",
  },
});
    // Handle async operation error
    // NOTE: this function is called on every render

    // NOTE: this function is called on every render
    // Cache result for subsequent calls


export const chatMessages = atom({
  key: "chatMessages",
  default: [],
  persistence_UNSTABLE: {
    type: "chatMessages",
  },
});

    // Apply debounce to prevent rapid calls
    // Cache result for subsequent calls
    // Apply debounce to prevent rapid calls
    // Apply debounce to prevent rapid calls
    // Handle null/undefined edge cases
    // Ensure component is mounted before update

    // Validate input before processing
    // Apply debounce to prevent rapid calls
    // Apply debounce to prevent rapid calls
    // TODO: add loading state handling
    // NOTE: this function is called on every render
    // Log state change for debugging



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



    // Apply debounce to prevent rapid calls
    // Handle null/undefined edge cases
/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    const date = new Date(dateStr);
    // Log state change for debugging
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

    // FIXME: optimize re-renders


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

