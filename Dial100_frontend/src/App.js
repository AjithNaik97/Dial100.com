import React from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import Register from './pages/Register';
import Login from './pages/Login';
import ContactPage from './pages/Contact';
import PlaintiffDashboardPage from './pages/PlaintiffDashboard';
import ComplaintPage from './pages/Complaint';
import AuthorityDashboardPage from './pages/AuthorityDashboard';
import ViewComplaintsPage from './pages/ViewComplaints';
import PlaintiffComplaintDetailsPage from './pages/PlaintiffComplaintDetails';
import PlaintiffUpdateDetailsPage from './pages/PlaintiffUpdateDetails';
import ProtectedRoute from './components/ProtectedRoute';
import './App.css';

// Component to conditionally render the Navbar
function ConditionalNavbar() {
  const location = useLocation();
  const hideNavbarPatterns = [
    '/plaintiff-dashboard',
    '/register-complaint',
    '/authority-dashboard',
    '/view-complaints',
    /^\/plaintiff-complaint-details\/.+/,  // Pattern to match dynamic IDs
    /^\/plaintiff-update-details\/.+/
  ];

  const shouldHideNavbar = hideNavbarPatterns.some(pattern =>
    typeof pattern === 'string'
      ? location.pathname === pattern
      : pattern.test(location.pathname)
  );

  return !shouldHideNavbar && <Navbar />;
}

function App() {
  return (
    <Router>
      <div className="app">
        <ConditionalNavbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/contact" element={<ContactPage />} />

          {/* Protected routes */}
          <Route
            path="/plaintiff-dashboard"
            element={
              <ProtectedRoute requiredRole="PLAINTIFF">
                <PlaintiffDashboardPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/register-complaint"
            element={
              <ProtectedRoute requiredRole="PLAINTIFF">
                <ComplaintPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/view-complaints"
            element={
              <ProtectedRoute requiredRole="PLAINTIFF">
                <ViewComplaintsPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/plaintiff-complaint-details/:complaintId"
            element={
              <ProtectedRoute requiredRole="PLAINTIFF">
                <PlaintiffComplaintDetailsPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/plaintiff-update-details/:complaintId"
            element={
              <ProtectedRoute requiredRole="PLAINTIFF">
                <PlaintiffUpdateDetailsPage />
              </ProtectedRoute>
            }
          />
          <Route
            path="/authority-dashboard"
            element={
              <ProtectedRoute requiredRole="AUTHORITY">
                <AuthorityDashboardPage />
              </ProtectedRoute>
            }
          />
        </Routes>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
