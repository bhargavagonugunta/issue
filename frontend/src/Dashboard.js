import BaseLayout from "./layouts/BaseLayout";
import { useNavigate } from "react-router-dom";

const Dashboard = () => {
  const posts = [
    { title: "First post", description: "This is first post", imgUrl: "1.jpg" },
    {
      title: "Second post",
      description: "This is Second post",
      imgUrl: "2.jpeg",
    },
    {
      title: "Third post",
      description: "This is Third post",
      imgUrl: "3.jpeg",
    },
    { title: "Fouth post", description: "This is Fouth post", imgUrl: "1.jpg" },
    {
      title: "Fifth post",
      description: "This is Fifth post",
      imgUrl: "2.jpeg",
    },
    {
      title: "Sixth post",
      description: "This is Sixth post",
      imgUrl: "3.jpeg",
    },
  ];


  const navigate = useNavigate();

  const handleCreatePost = () => {
    navigate('/createPost');
  }
  const renderPosts = () => {
    return (
      <div className="grid grid-cols-3 gap-4 mx-auto max-w-7xl px-4 sm:px-6 md:px-8">
        {posts.map((post, index) => {
          return (
            <div
              className="shadow-lg rounded bg-white p-4 cursor-pointer"
              key={index}
            >
              <img
                src={post.imgUrl}
                alt="This is an img"
                className="h-64 min-w-full rounded"
              ></img>
              <h3 className="text-lg font-bold">{post.title}</h3>
              <p>{post.description}</p>
            </div>
          );
        })}
      </div>
    );
  };

  return (
    <BaseLayout>
      <main className="flex-1">
        <div className="py-6">
          <div className="mx-auto max-w-7xl px-4 sm:px-6 md:px-8 flex items-center justify-between">
            <h1 className="text-2xl font-semibold text-gray-900">Dashboard</h1>
            <div>
              <button
                type="button"
                onClick={handleCreatePost}
                className="flex w-full justify-center rounded-md border border-transparent bg-indigo-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 "
              >
                Create post
              </button>
            </div>
          </div>
          {renderPosts()}
        </div>
      </main>
    </BaseLayout>
  );
};

export default Dashboard;
