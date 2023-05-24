import { Container, Nav, Navbar } from "react-bootstrap";
import styled from "styled-components";

function Header() {
  return (
    <>
      <Navbar style={{ background: "url(/Opa.jpg)" }}>
        <Container>
          <div className="bg">
            <img src="/weather.png" width="100%" height="50px" />
          </div>
          <Navbar.Brand href="#home" style={{ color: "white" }}>
            오늘의 날씨
          </Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#alert" style={{ color: "white" }}>
              공지사항
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default Header;
