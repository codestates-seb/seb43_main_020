import { Outlet } from "react-router-dom";
import { Button, Form } from "react-bootstrap";

function Write() {
  return (
    <Form>
      <p></p>
      <Form.Group controlId="titleInput">
        <Form.Label>제목</Form.Label>

        <Form.Control required type="email" placeholder="" />
      </Form.Group>
      <p>분류</p>
      <Form.Select aria-label="Default select example">
        <option value="1">운동</option>
      </Form.Select>
      <Form.Group controlId="contentText">
        <Form.Label>내용</Form.Label>
        <Form.Control required as="textarea" rows={20} />
      </Form.Group>
      <Button variant="primary" type="submit">
        저장
      </Button>
    </Form>
  );
}

export default Write;
