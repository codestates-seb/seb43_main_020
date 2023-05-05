import { Outlet } from "react-router-dom";

function Write() {
  return (
    <div>
      <p>글작성페이지입니다</p>
      <Outlet></Outlet>
    </div>
  );
}

export default Write;
