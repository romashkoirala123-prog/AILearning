import "../style/Login.css";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../context/AuthContext.jsx";
import authService from "../../services/authService.js";
import { BrainCircuit, Mail, Lock, ArrowRight } from "lucide-react";
import toast from 'react-hot-toast';


const LoginPage = () => {

  const [email, setEmail] = useState('testemail@gmail.com');
  const [password, setPassword] = useState('test123');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [focusedField, setFocusedField] = useState(null);

  


  return (
    <div className="login-body">
      <div className="login-container">
        <h1>Welcome Back</h1>
        <p className="subtitle">Sign in to continue</p>

        <form className="login-form">
          <input
            type="email"
            placeholder="Email Address"
            className="login-input"
          />

          <input
            type="password"
            placeholder="Password"
            className="login-input"
          />

          <button type="submit" className="login-btn">
            Login
          </button>
        </form>

        <p className="signup-text">
          Don't have an account? <a href="/register">Sign Up</a>
        </p>
      </div>
    </div>
  );
};

export default LoginPage;
