import { Outlet } from "react-router";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import { useEffect } from "react";

function Alert() {
  return (
    <>
      <Table className="table table-hover" style={{ backgroundColor: "white" }}>
        <thead>
          <tr>
            <th>번호</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>코딩재밌네</td>
            <td>뻥이에요</td>
            <td>5월7일</td>
            <td>500,000</td>
          </tr>
          <tr>
            <td>2</td>
            <td>컴포넌트분리하는거</td>
            <td>꿀잼</td>
            <td>5월7일</td>
            <td>1,000,000</td>
          </tr>
        </tbody>
      </Table>
      <Outlet></Outlet>
    </>
  );
}

export default Alert;
