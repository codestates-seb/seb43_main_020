import styled from "styled-components";
import { CommonButton } from "./Buttons";
import { useState } from "react";
import { Routes, Route, useNavigate, Outlet } from "react-router-dom";
import Write from "../pages/Write";
let Box = styled.div`
padding:20px
text-align:left;
border-bottom:1px solid grey;
border-top:1px solid grey;
`;

let Box2 = styled.div`
padding:20px
text-align:left;
border-bottom:1px solid grey;
`;
function App() {
  let navigate = useNavigate();
  return (
    <Routes>
      <Route path="/Write" element={<Write />}></Route>
    </Routes>
  );
}

function Board() {
  let navigate = useNavigate();
  return (
    <>
      <div className="bg">
        <img src="/hobby.jpg" width="100%" height="400px" />
      </div>
      <CommonButton
        onClick={() => {
          navigate("/Write");
        }}
      >
        🖊작성하기
      </CommonButton>
      <CommonButton>🔽최신순</CommonButton>
      <div>
        <Box>
          <span>🔄</span>
          <input type="search" placeholder="게시판 내에서 검색"></input>
          <span>⬅</span>
          <span>➡</span>
        </Box>
      </div>

      <div>
        <Box2>
          <h4>유저이름</h4>
          <p>글제목</p>
          <p>분류</p>
        </Box2>
      </div>
      <Routes>
        <Route path="/Write" element={<Write />}></Route>
      </Routes>
    </>
  );
}

export default (Board, App);
