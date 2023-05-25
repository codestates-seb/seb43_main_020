import { useState } from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";

function Comment() {
  let [like, setLike] = useState(0);
  let [put, setPut] = useState("");
  return (
    <Card className="text-center" style={{ height: "500px" }}>
      <Card.Header>공지사항</Card.Header>
      <Card.Body>
        <Card.Title></Card.Title>
        <Card.Text></Card.Text>

        <span
          onClick={() => {
            setLike(like + 1);
          }}
        >
          좋아요💛
        </span>
        <p>{like}</p>
        {/* <Button variant="primary">Go somewhere</Button> */}
      </Card.Body>

      <Card.Footer className="text-muted">7 days ago</Card.Footer>
    </Card>
  );
}

export default Comment;
