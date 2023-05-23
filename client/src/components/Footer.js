import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

function Footer() {
  return (
    <>
      {["Primary"].map((variant) => (
        <Card
          bg={variant.toLowerCase()}
          key={variant}
          text={variant.toLowerCase() === "light" ? "dark" : "white"}
          style={{ width: "100%" }}
          className="mb-2"
        >
          <Card.Body className="FooterCard">
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
