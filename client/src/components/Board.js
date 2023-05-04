import styled from "styled-components";
import { CommonButton } from "./Buttons";
import { useState } from "react";

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

function Board() {
  return (
    <>
      <div className="bg">
        <img src="/hobby.jpg" width="100%" height="400px" />
      </div>
      <CommonButton>🖊작성하기</CommonButton>
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
    </>
  );
}

export default Board;
