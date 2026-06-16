import './Navbar.css'

const Navbar = () => {

  const isLoggedIn = false;  

  return (
    <>
      <div className="nav-body">
        <div className="nav-logo"><img src="../src/assets/nav-logo.png" /></div>
        <div className="nav-links">
          <a>Chat</a>
          <a>Quiz</a>
        </div> 
        {isLoggedIn ? (
        <div className="nav-profile">
          <img
            src=""
            alt="Profile"
            className="profile-img"
          />
        </div>
      ) : (
        <div className="nav-login">
          <button>Login</button>
        </div>
      )}      </div>
    </>
  )
}

export default Navbar
