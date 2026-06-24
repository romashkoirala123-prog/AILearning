import "../style/Login.css";

const Login = () => {
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

export default Login;
