import BaseLayout from "../layouts/BaseLayout";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { environment } from "../config";
import { useState } from "react";

const CreatePost = () => {
  const [state, setState] = useState({});
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log("state : ",state);
    await axios.post(`${environment.baseUrl}/issue/add`, {
        ...state,
        status: "open",
      },{
        withCredentials: true,
        headers: {'Access-Control-Allow-Origin': '*', 'Content-Type': 'application/json'}
      })
      .then((data) => {
        navigate("/");
      })
      .catch((err) => console.log(err));
    navigate("/dashboard");
  };

  const handleInputOnchange = (event) => {
    const fieldName = event.target.name;
    setState({
      ...state,
      [fieldName]: event.target.value,
    });
  };

  return (
    <BaseLayout>
      <div className="sm:mx-auto sm:w-full sm:max-w-md">
        <h2 className="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900">
          Create Post
        </h2>
      </div>

      <div className="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
        <div className="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
          <form className="space-y-6">
          <div>
              <label
                htmlFor="issueTitle"
                className="block text-sm font-medium text-gray-700"
              >
                Title
              </label>
              <div className="mt-1">
                <input
                  id="issueTitle"
                  name="issueTitle"
                  type="issueTitle"
                  autoComplete="issueTitle"
                  required
                  className="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
                  onChange={(event) => handleInputOnchange(event)}
                />
              </div>
            </div>
            
            <div>
              <label
                htmlFor="issueDescription"
                className="block text-sm font-medium text-gray-700"
              >
                Description
              </label>
              <div className="mt-1">
                <input
                  id="issueDescription"
                  name="issueDescription"
                  type="issueDescription"
                  autoComplete="issueDescription"
                  required
                  className="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
                  onChange={(event) => handleInputOnchange(event)}
                />
              </div>
            </div>

            <div>
              <label
                htmlFor="location"
                className="block text-sm font-medium text-gray-700"
              >
                Location
              </label>
              <div className="mt-1">
                <input
                  id="location"
                  name="location"
                  type="location"
                  autoComplete="location"
                  required
                  className="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-indigo-500 focus:outline-none focus:ring-indigo-500 sm:text-sm"
                  onChange={(event) => handleInputOnchange(event)}
                />
              </div>
            </div>

            <div className="flex gap-3">
              <button
                type="submit"
                onClick={(e) => handleSubmit(e)}
                className="flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
              >
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </BaseLayout>
  );
};

export default CreatePost;
