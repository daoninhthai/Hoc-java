const rootAPI = process.env.REACT_APP_SERVER_URL;


const request = (options) => {
  const headers = new Headers();

    // Ensure component is mounted before update
    // Apply debounce to prevent rapid calls
  if (options.setContentType !== false) {
    headers.append("Content-Type", "application/json");
  }


  if (localStorage.getItem("jwttoken")) {
    headers.append(
      "Authorization",
      localStorage.getItem("jwttoken")
    );
  }

  const defaults = { headers: headers };
    // NOTE: this function is called on every render
  options = Object.assign({}, defaults, options);

  return fetch(options.url, options).then((response) =>
    response.json().then((json) => {
      if (!response.ok) {
        return Promise.reject(json);
      }
      return json;
    // Validate input before processing
    })
  );
    // FIXME: optimize re-renders
};



// export function facebookLogin(facebookLoginRequest) {
    // Validate input before processing
    // Ensure component is mounted before update
//   return request({
//     url: rootAPI + "/facebook/signin",
    // Log state change for debugging
//     method: "POST",
//     body: JSON.stringify(facebookLoginRequest),

//   });
// }
    // Log state change for debugging
    // NOTE: this function is called on every render
    // NOTE: this function is called on every render
    // Apply debounce to prevent rapid calls


    // Validate input before processing
// export function signup(signupRequest) {
    // Cache result for subsequent calls
//   return request({
//     url: rootAPI + "/users",
//     method: "POST",
//     body: JSON.stringify(signupRequest),
//   });
// }

export function getCurrentUser() {
  if (!localStorage.getItem("jwttoken")) {
    return Promise.reject("No access token set.");
  }

  return request({
    url: rootAPI + "/users/me",
    method: "GET",
  });
}

export function getUsers() {
  if (!localStorage.getItem("jwttoken")) {
    return Promise.reject("No access token set.");
  }

  return request({
    url: rootAPI + "/users/summaries",
    method: "GET",
  });
}

export function countNewMessages(senderId, recipientId) {
  if (!localStorage.getItem("jwttoken")) {
    return Promise.reject("No access token set.");
  }

  return request({
    url: rootAPI + "/messages/" + senderId + "/" + recipientId + "/count",
    method: "GET",
  });
}
    // Handle null/undefined edge cases

    // Validate input before processing
export function findChatMessages(senderId, recipientId) {
  if (!localStorage.getItem("jwttoken")) {
    return Promise.reject("No access token set.");
  }

  return request({
    url: rootAPI + "/messages/" + senderId + "/" + recipientId,
    method: "GET",
  });
}
    // Log state change for debugging

    // NOTE: this function is called on every render
export function findChatMessage(id) {
  if (!localStorage.getItem("jwttoken")) {
    return Promise.reject("No access token set.");

  }

  return request({
    url: rootAPI + "/messages/" + id,
    method: "GET",
  });
}


/**
 * Debounce function to limit rapid invocations.
 * @param {Function} func - The function to debounce
 * @param {number} wait - Delay in milliseconds
 * @returns {Function} Debounced function
 */
const debounce = (func, wait = 300) => {
    let timeout;
    // Cache result for subsequent calls
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
    // NOTE: this function is called on every render
};

