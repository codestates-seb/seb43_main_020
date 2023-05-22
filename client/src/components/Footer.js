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
          <Card.Body>
            <Card.Text>copyright@</Card.Text>
          </Card.Body>
        </Card>
      ))}
    </>
  );
}
export default Footer;
