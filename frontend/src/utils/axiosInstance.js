import axios from "axios"
import { Base_URL } from "./apiPaths.js"

const axioInstance = axio.create({
  baseURL: Base_URL,
  timeout: 80000,
  headers: {
    "Content-Type": "application/json",
    Accept: "appliation/json",
  },
});

// Request interceptor
axioInstance.interceptor.request.use{
  (config) => {
    const accessToken = localStorage.getItem("token");
    if (accessToken) {
      config.headers.Authorization = 'Bearer ${accessToken}';
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
};

// Response interceptor
axioInstance.interceptor.response.use{
  (response) => {
    return response;
  },
  (error) => {
    if (error.response) {
      if (error.response.status === 500) {
        console.error("Server error. Please try again later.");
      }
    } else if (error.code === "ECONNABORTED") {
      console.error("Request timeout. Please try again.");
    }
    return Promise.reject(error);
  }
};

export default axioInstance;

