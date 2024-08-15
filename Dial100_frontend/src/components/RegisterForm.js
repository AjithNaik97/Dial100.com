import React, { useState } from 'react';
import '../styles/RegisterForm.css';

function RegisterForm() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    phone: '',
    password: '',
    confirmPassword: '',
    address: '', // Add address field
    role: 'PLAINTIFF'
  });

  const [errors, setErrors] = useState({});
  const [message, setMessage] = useState('');

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const validateForm = () => {
    let formErrors = {};

    // Validate name
    if (!formData.name.trim()) {
      formErrors.name = 'Name is required';
    }

    // Validate email
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!formData.email.trim()) {
      formErrors.email = 'Email is required';
    } else if (!emailPattern.test(formData.email)) {
      formErrors.email = 'Invalid email format';
    }

    // Validate phone
    if (!formData.phone.trim()) {
      formErrors.phone = 'Phone number is required';
    }

    // Validate address
    if (!formData.address.trim()) {
      formErrors.address = 'Address is required';
    }

    // Validate password
    if (!formData.password.trim()) {
      formErrors.password = 'Password is required';
    } else if (formData.password.length < 6) {
      formErrors.password = 'Password must be at least 6 characters long';
    }

    // Validate confirm password
    if (!formData.confirmPassword.trim()) {
      formErrors.confirmPassword = 'Confirm Password is required';
    } else if (formData.password !== formData.confirmPassword) {
      formErrors.confirmPassword = 'Passwords do not match';
    }

    setErrors(formErrors);
    return Object.keys(formErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (validateForm()) {
      try {
        const response = await fetch('http://localhost:8080/api/users', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(formData), // Include address in the request body
        });

        const result = await response.json();

        if (response.ok) {
          setMessage(result.message); // Set success message
          console.log('User Registered:', result.data);
          // Optionally reset form fields
          setFormData({
            name: '',
            email: '',
            phone: '',
            password: '',
            confirmPassword: '',
            address: '', // Reset address field
            role: 'PLAINTIFF'
          });
        } else {
          setMessage('Registration failed'); // Handle error message
          console.error('Registration failed:', result);
        }
      } catch (error) {
        setMessage('Error submitting form'); // Handle network error
        console.error('Error submitting form:', error);
      }
    }
  };

  return (
    <div className="register-form-container">
      <h2>REGISTRATION</h2>
      <form className="register-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Name"
          value={formData.name}
          onChange={handleChange}
          required
        />
        {errors.name && <p className="error">{errors.name}</p>}

        <select name="role" value={formData.role} onChange={handleChange}>
          <option value="PLAINTIFF">Plaintiff</option>
          <option value="AUTHORITY">Authority</option>
          <option value="ADMIN">Admin</option>
        </select>

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        />
        {errors.email && <p className="error">{errors.email}</p>}

        <input
          type="text"
          name="phone"
          placeholder="Phone"
          value={formData.phone}
          onChange={handleChange}
          required
        />
        {errors.phone && <p className="error">{errors.phone}</p>}

        <input
          type="text"
          name="address"
          placeholder="Address"
          value={formData.address}
          onChange={handleChange}
          required
        />
        {errors.address && <p className="error">{errors.address}</p>}

        <input
          type="password"
          name="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          required
        />
        {errors.password && <p className="error">{errors.password}</p>}

        <input
          type="password"
          name="confirmPassword"
          placeholder="Confirm Password"
          value={formData.confirmPassword}
          onChange={handleChange}
          required
        />
        {errors.confirmPassword && <p className="error">{errors.confirmPassword}</p>}

        <button type="submit">Register</button>

        {message && <p className="message">{message}</p>} {/* Display message */}
      </form>
    </div>
  );
}

export default RegisterForm;
