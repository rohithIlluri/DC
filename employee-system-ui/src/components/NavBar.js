import React from "react";

const Navbar = () => {
  return (
    <div className="bg-gray-800">
      <div className="h-16 px-8 flex items-center justify-between">
        <p className="text-white font-bold text-xl hover:text-gray-300 transition-colors duration-300">
          Employee Management System
        </p>
        <div className="flex space-x-4">
          <button className="text-white hover:bg-gray-700 px-4 py-2 rounded transition-all duration-300 ease-in-out transform hover:scale-105">
            Dashboard
          </button>
          <button className="text-white hover:bg-gray-700 px-4 py-2 rounded transition-all duration-300 ease-in-out transform hover:scale-105">
            Settings
          </button>
          <button className="text-white hover:bg-gray-700 px-4 py-2 rounded transition-all duration-300 ease-in-out transform hover:scale-105">
            Logout
          </button>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
