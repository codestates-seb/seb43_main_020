import { Outlet } from "react-router";
import Table from "react-bootstrap/Table";
import Pagination from "react-bootstrap/Pagination";
import Number from "../components/Pagination";
function Writelist() {
  return (
    <>
      <Table className="table table-hover">
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
            <td>코드스테이츠</td>
            <td>망해라</td>
            <td>5월7일</td>
            <td>500,000</td>
          </tr>
          <tr>
            <td>2</td>
            <td>어휴하기싫어</td>
            <td>망해라</td>
            <td>5월7일</td>
            <td>1,000,000</td>
          </tr>
        </tbody>
      </Table>
      <Number />
    </>
  );
}

export default Writelist;
