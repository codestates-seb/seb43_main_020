import { Container, Nav, Navbar } from "react-bootstrap";
import styled from "styled-components";

function Header() {
  return (
    <>
      <Navbar bg="primary" variant="dark">
        <Container>
          <div className="bg">
            <img src="/weather.jpg" width="100%" height="50px" />
          </div>
          <Navbar.Brand href="#home">오늘의 날씨</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#alert">공지사항</Nav.Link>
            <Nav.Link href="#alert">로그인</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default Header;
