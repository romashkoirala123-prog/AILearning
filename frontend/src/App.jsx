import { Route, Routes } from "react-router";
import HomePage from "./pages/HomePage";
import Profile from "./pages/Profile";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Quiz from "./pages/Quiz";
import Navbar from "./Components/Navbar/Navbar";

const App = () => {
  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} /> 
        <Route path="/profile" element={<Profile />} /> 
        <Route path="/quiz" element={<Quiz />} /> 
        <Route path="/login" element={<Login />} /> 
        <Route path="/register" element={<Register />} /> 
      </Routes>
  
    </div>
  ); 
}

export default App
