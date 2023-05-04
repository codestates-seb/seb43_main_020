import styled from "styled-components";
import { ReactComponent as SearchIcon } from "../images/searchIcon.svg";

const SearchContainer = styled.form`
  position: relative;
  flex-grow: 1;

  #search-icon {
    position: absolute;
    left: 0.5em;
    top: 50%;
    margin-top: -9px;
  }
`;

const SearchBar = styled.input`
  display: block;
  width: 100%;
  background-color: #fff;
  border: 1px solid #d3d3d3;
  font-size: 13px;
  color: black;
  border-radius: 16px;
  padding: 0.6em 0.7em;
  padding-left: 32px;
  outline: none;
  &:focus {
    border-color: #408ef1;
  }
`;

const Search = () => {
  return (
    <SearchContainer>
      <SearchIcon
        id="search-icon"
        width="18px"
        height="18px"
        fill="hsl(210,8%,55%)"
      />
      <SearchBar placeholder="검색" />
    </SearchContainer>
  );
};

export default Search;
