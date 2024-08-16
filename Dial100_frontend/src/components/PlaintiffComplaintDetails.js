import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import '../styles/PlaintiffComplaintDetails.css';

function PlaintiffComplaintDetails() {
  const navigate = useNavigate();
  const { complaintId } = useParams(); // Retrieve the complaintId from the URL
  const [complaint, setComplaint] = useState(null); // State to store complaint details

  // Function to handle logout
  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/');
  };

  // Fetch complaint details on component mount
  useEffect(() => {
    fetch(`http://localhost:8080/api/complaints/${complaintId}`)
      .then((response) => response.json())
      .then((data) => setComplaint(data))
      .catch((error) => console.error('Error fetching complaint details:', error));
  }, [complaintId]);

  return (
    <div className="dashboard">
      <div className="side-nav">
        <div className="logo">Logo</div>
        <ul>
          <li><a href="/register-complaint">Register Complaint</a></li>
          <li><a href="/view-complaints">View Complaints</a></li>
        </ul>
      </div>
      
      <div className="content-area">
        <div className="top-nav">
          <input type="text" className="search-bar" placeholder="Search here..." />
          <div className="profile-options">
            <a href="/profile">Your Profile</a>
            <a href="/" onClick={handleLogout}>Logout</a>
          </div>
        </div>

        <div className="main-content">
          <h1>Complaint ID {complaintId} Details:</h1>
          {complaint ? (
            <div>
              <p><strong>Date Filed:</strong> {complaint.dateFiled}</p>
              <p><strong>Description:</strong> {complaint.description}</p>
              <p><strong>Status:</strong> {complaint.status}</p>
              <p><strong>Crime ID:</strong> {complaint.crime.crimeId}</p>
              <p><strong>Crime Type:</strong> {complaint.crime.crimeType}</p>
              <p><strong>Crime Description:</strong> {complaint.crime.description}</p>
              <p><strong>Penalty:</strong> {complaint.crime.penalty}</p>
            </div>
          ) : (
            <p>Loading complaint details...</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default PlaintiffComplaintDetails;
