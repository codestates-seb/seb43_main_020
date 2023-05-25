import { useState } from "react";
import styled from "styled-components";
import axios from "axios";
import { Routes } from "react-router";

function App() {
  const API_KEY = "b5e6daa16ad773508276891721b6c4ba";
  const [location, setLocation] = useState("");
  const [result, setResult] = useState({});
  const [result2, setResult2] = useState({});
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
      <AppWrap>
        <div className="appContentWrap">
          <input
            style={{
              width: "800px",
              height: "50px",
              textAlign: "center",
              borderRadius: "10px",
              background: "url(/Atlas.jpg)",
            }}
            className="inputbox"
            placeholder="지역을 입력하세요 
            Please enter your desired region"
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
              <div>
                <img
                  src={
                    "https://openweathermap.org/img/wn/" +
                    result.data.weather[0].icon +
                    "@2x.png"
                  }
                />
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
  height: 60vh;
  
  .inputbox{
    border: "red 1px solid", 
    width: "800px",
    height: "50px",
    text-align:"center",
    background-color:"red"
  }
  .inputcenter{
   margin-left:380px;
    position:absolute;
    border-radius: 8px;

  }

  .appContentWrap {
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%)
    position: absolute;
    padding: 200px;
    text-align:center;
    padding:50px;
  }
`;

const ResultWrap = styled.div`
  margin-top: 50px;
  padding: 10px;
  border-radius: 8px;
  .city {
    font-size: 24px;
  }
  .temperature {
    font-size: 60px;
    margin-top: 8px;
  }
  .sky {
    font-size: 20px;
    margin-top: 8px;
  }
`;

// style={{ background: "url(/F.jpg)" }}
