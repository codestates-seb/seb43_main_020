import styled from "styled-components";
import { CommonButton } from "./Buttons";
import Search from "./Search";

const HeaderContainer = styled.header`
  width: 100%;
  position: fixed;
  z-index: 10;
  height: 50px;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
  border-bottom: 1px solid #d3d3d3;
  margin-bottom: 10px;

  .header-container {
    width: 1264px;
    max-width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .logo {
      height: 100%;
      margin: 0;
      padding: 0 8px;
      display: flex;
      align-items: center;
    }

    .button-container {
      display: flex;
    }

    .button-container button {
      padding: 8px 10px;
    }
  }
`;

const Header = () => {
  return (
    <HeaderContainer>
      <div className="header-container">
        <h1 className="logo">logo</h1>
        <Search />
        <div className="button-container">
          <CommonButton>Log in</CommonButton>
          <CommonButton
            bgColor="var(--blue-500)"
            color="#fff"
            border="transparent"
          >
            Sign up
          </CommonButton>
        </div>
      </div>
    </HeaderContainer>
  );
};

export default Header;
