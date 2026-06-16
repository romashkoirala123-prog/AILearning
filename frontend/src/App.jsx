import { Route, Routes } from "react-router";
import HomePage from "./pages/HomePage";
import Profile from "./pages/Profile";
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
      </Routes>
  
    </div>
  ); 
}

export default App
