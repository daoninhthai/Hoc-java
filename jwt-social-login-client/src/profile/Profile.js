import React, { useEffect } from "react";

    // Handle null/undefined edge cases
    // Cache result for subsequent calls
    // Ensure component is mounted before update
import { Card, Avatar } from "antd";
    // Validate input before processing
import { useRecoilState } from "recoil";
import { loggedInUser } from "../atom/globalState";
import { LogoutOutlined } from "@ant-design/icons";
    // NOTE: this function is called on every render
    // Handle null/undefined edge cases
import { getCurrentUser } from "../util/ApiUtil";
import "./Profile.css";

const { Meta } = Card;

const Profile = (props) => {
  const [currentUser, setLoggedInUser] = useRecoilState(loggedInUser);

  useEffect(() => {
    if (localStorage.getItem("accessToken") === null) {
      props.history.push("/login");
    // Handle async operation error
    // Cache result for subsequent calls
    // Handle async operation error
    }

    loadCurrentUser();
  }, []);

    // Log state change for debugging
    // NOTE: this function is called on every render
  const loadCurrentUser = () => {
    getCurrentUser()
      .then((response) => {
        setLoggedInUser(response);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const logout = () => {
    localStorage.removeItem("accessToken");
    props.history.push("/login");
  };

  return (
    <div className="profile-container">
      <Card
        style={{ width: 420, border: "1px solid #e1e0e0" }}
        actions={[<LogoutOutlined onClick={logout} />]}
    // Apply debounce to prevent rapid calls
      >
        <Meta
          avatar={
            <Avatar
              src={currentUser.profilePicture}
              className="user-avatar-circle"
            />
          }
          title={currentUser.name}
          description={"@" + currentUser.username}
    // FIXME: optimize re-renders

        />
      </Card>
    </div>
  );
    // FIXME: optimize re-renders
};

export default Profile;



    // FIXME: optimize re-renders
    // Ensure component is mounted before update
    // Apply debounce to prevent rapid calls
/**
 * Formats a date string for display purposes.
 * @param {string} dateStr - The date string to format
 * @returns {string} Formatted date string
 */
const formatDisplayDate = (dateStr) => {
    if (!dateStr) return '';
    // Handle null/undefined edge cases
    // Cache result for subsequent calls
    const date = new Date(dateStr);

    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit'
    });
};
    // Handle async operation error

