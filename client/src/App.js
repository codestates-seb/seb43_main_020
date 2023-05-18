import { useState } from "react";
import Header from "./components/Header";
import styled from "styled-components";
import axios from "axios";

function App() {
  const API_KEY = "b5e6daa16ad773508276891721b6c4ba";
  const [location, setLocation] = useState("");
  const [result, setResult] = useState({});
  const url = `https://api.openweathermap.org/data/2.5/weather?q=${location}&appid=${API_KEY}`;

  const searchWeather = async (e) => {
    if (e.key === "Enter") {
      try {
        const data = await axios({
          method: "get",
          url: url,
        });
        console.log(data);
        setResult(data);
      } catch (err) {
        alert(err);
      }
    }
  };
  return (
    <>
      <Header />
      <AppWrap>
        <div className="appContentWrap">
          <input
            placeholder="지역을 입력하세요"
            value={location}
            onChange={(e) => {
              setLocation(e.target.value);
            }}
            type="text"
            onKeyDown={searchWeather}
          />
          {Object.keys(result).length !== 0 && (
            <ResultWrap>
              <div className="city">{result.data.name}</div>
              <div className="temperature">
                {Math.round((result.data.main.temp - 273.15) * 10) / 10}°C
              </div>
              <div className="sky">{result.data.weather[0].main}</div>
            </ResultWrap>
          )}
        </div>
      </AppWrap>
    </>
  );
}

export default App;

const AppWrap = styled.div`
  width: 100vw;
  height: 100vh;
  border: 1px red solid;

  .appContentWrap {
    left: 30%;
    top: 30%;
    transform translate(-30%,-30%)
    positon: aboulute;
    border: 1px blue solid;
    padding: 300px;
  }
`;

const ResultWrap = styled.div`
  margin-top: 50px;
  padding: 10px;
  border: 1px black solid;
  border-radius: 8px;
`;
