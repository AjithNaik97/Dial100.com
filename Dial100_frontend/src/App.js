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
import ProtectedRoute from './components/ProtectedRoute'; // Import ProtectedRoute
import './App.css';

// Component to conditionally render the Navbar
function ConditionalNavbar() {
  const location = useLocation();
  const hideNavbarRoutes = ['/plaintiff-dashboard', '/register-complaint', '/authority-dashboard'];
  const shouldHideNavbar = hideNavbarRoutes.includes(location.pathname);
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
