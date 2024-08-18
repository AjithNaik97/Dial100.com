import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import '../styles/AuthorityComplaintDetails.css'; 

function AuthorityComplaintDetails() {
  const navigate = useNavigate();
  const { complaintId } = useParams();
  const [complaint, setComplaint] = useState(null);

  const handleLogout = () => {
    localStorage.removeItem('user');
    navigate('/');
  };

  useEffect(() => {
    fetch(`http://localhost:8080/api/complaints/${complaintId}`)
      .then((response) => response.json())
      .then((data) => setComplaint(data))
      .catch((error) => console.error('Error fetching complaint details:', error));
  }, [complaintId]);

  const handleAddEvidence = () => {
    navigate(`/add-investigate/${complaintId}`);
  };

  return (
    <div className="dashboard">
      <div className="side-nav">
        <div className="logo">Dial100</div>
        <ul>
          <li><a href="/all-new-complaints">All New Complaints</a></li>
          <li><a href="/my-investigations">My Investigations</a></li>
        </ul>
      </div>
      
      <div className="content-area">
        <div className="top-nav">
          <input type="text" className="search-bar" placeholder="Search here..." />
          <div className="profile-options">
            <a href="/profile">Your Profile</a>
            <a href="/" onClick={handleLogout}>Logout</a> {/* Updated to call handleLogout */}
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
              <button className="button" onClick={handleAddEvidence}>Investigate</button>
            </div>
          ) : (
            <p>Loading complaint details...</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default AuthorityComplaintDetails;
