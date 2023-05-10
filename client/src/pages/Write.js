import { Outlet } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
import { useEffect, useState } from "react";
import Writelist from "./Writelist";
import axios from "axios";

function Write() {
  let [title, setTitle] = useState(["임시", "데이터"]);
  let [content, setContent] = useState([
    "사진찍기",
    "운동",
    "영화감상",
    "요리",
    "독서",
    "산책",
    "낚시",
    "게임",
    "그림",
    "노래",
    "자원봉사",
  ]);

  return (
    <div>
      <p></p>
      <Form>
        <Form.Group controlId="titleInput">
          <Form.Label>제목</Form.Label>
          <Form.Control required type="text" placeholder="제목을 입력하세요" />
        </Form.Group>
        <p></p>
        <p>분류</p>
        <Form.Select aria-label="Default select example">
          <option value="1">{content[0]}</option>
          <option value="1">{content[1]}</option>
          <option value="1">{content[2]}</option>
          <option value="1">{content[3]}</option>
          <option value="1">{content[4]}</option>
          <option value="1">{content[5]}</option>
          <option value="1">{content[6]}</option>
          <option value="1">{content[7]}</option>
          <option value="1">{content[8]}</option>
          <option value="1">{content[9]}</option>
          <option value="1">{content[10]}</option>
        </Form.Select>
        <Form.Group controlId="contentText">
          <Form.Label>내용</Form.Label>
          <Form.Control required as="textarea" rows={20} />
        </Form.Group>

        <Button variant="primary" type="submit">
          저장
        </Button>
        <Button variant="primary" type="submit">
          취소
        </Button>
      </Form>
    </div>
  );
}

export default Write;
