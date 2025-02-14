import React from "react";
import { useNavigate } from "react-router-dom";

const Employee = ({ employee, deleteEmployee }) => {
  const navigate = useNavigate();

  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <tr key={employee.id} className="hover:bg-gray-100 transition-colors duration-200">
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-800 font-medium">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-800 font-medium">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-800 font-medium">{employee.emailId}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <button
          onClick={(e, id) => editEmployee(e, employee.id)}
          className="text-indigo-600 hover:text-indigo-800 px-4 transition-colors duration-200 hover:underline focus:outline-none">
          Edit
        </button>
        <button
          onClick={(e, id) => deleteEmployee(e, employee.id)}
          className="text-red-600 hover:text-red-800 px-4 transition-colors duration-200 hover:underline focus:outline-none">
          Delete
        </button>
      </td>
    </tr>
  );
};

export default Employee;
