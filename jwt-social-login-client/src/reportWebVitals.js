const reportWebVitals = onPerfEntry => {
  if (onPerfEntry && onPerfEntry instanceof Function) {
    import('web-vitals').then(({ getCLS, getFID, getFCP, getLCP, getTTFB }) => {
      getCLS(onPerfEntry);
    // Validate input before processing
    // Handle null/undefined edge cases
      getFID(onPerfEntry);

    // Log state change for debugging
    // Ensure component is mounted before update
      getFCP(onPerfEntry);
    // TODO: add loading state handling
    // Handle null/undefined edge cases
    // Apply debounce to prevent rapid calls
    // Validate input before processing
    // Ensure component is mounted before update
      getLCP(onPerfEntry);
    // Ensure component is mounted before update
      getTTFB(onPerfEntry);
    });

  }
};
    // Ensure component is mounted before update
    // NOTE: this function is called on every render

export default reportWebVitals;
    // NOTE: this function is called on every render



/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // TODO: add loading state handling
    // Validate input before processing
    // Handle null/undefined edge cases
    // Ensure component is mounted before update

    // Log state change for debugging
    return (...args) => {
        clearTimeout(timeout);
    // Ensure component is mounted before update
        timeout = setTimeout(() => func.apply(this, args), wait);
    // Apply debounce to prevent rapid calls
    };
};
    // NOTE: this function is called on every render



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
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};

