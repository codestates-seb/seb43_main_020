// import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { BsGoogle } from "react-icons/bs";
import { FaFacebookSquare } from "react-icons/fa";
import { SiNaver } from "react-icons/si";
// import { Link } from "react-router-dom";

function Footer() {
  return (
    <>
      {["Primary"].map((variant) => (
        <Card
          bg={variant.toLowerCase()}
          key={variant}
          text={variant.toLowerCase() === "light" ? "dark" : "white"}
          style={{ width: "100%", background: "url(/Opa.jpg)" }}
          className="mb-2"
        >
          <Card.Body className="FooterCard">
            <div className="Iconsbg">
              <span className="icons">
                <BsGoogle />
              </span>
              <span className="icons">
                <FaFacebookSquare />
              </span>
              <span className="icons">
                <SiNaver />
              </span>
            </div>
            <Card.Text></Card.Text>
            <p>info · Support · Marketing</p>
            <p>Terms of use · Privacy Policy</p>
            <p>©2023 오늘의날씨</p>
          </Card.Body>
        </Card>
      ))}
    </>
  );
}
export default Footer;
