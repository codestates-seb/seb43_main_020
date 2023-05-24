import { useState } from "react";
import Header from "./components/Header";
import styled from "styled-components";
import axios from "axios";
import Footer from "./components/Footer";
import Animation from "./components/Animation";

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
      <Header />
      <Animation />
      <AppWrap>
        <div className="appContentWrap">
          <div className="inputcenter">
            <input
              className="inputbox"
              placeholder="지역을 입력하세요"
              value={location}
              onChange={(e) => {
                setLocation(e.target.value);
              }}
              type="text"
              onKeyDown={searchWeather}
            />
          </div>
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

      <Footer />
    </>
  );
}

export default App;

function Sunny() {
  return (
    <div>
      <img src="sunny.png"></img>
    </div>
  );
}
function Rain() {
  return (
    <div>
      <img src="rain.png"></img>
    </div>
  );
}
function Snow() {
  return (
    <div>
      <img src="snow.png"></img>
    </div>
  );
}
function Cloud() {
  return (
    <div>
      <img src="cloud.png"></img>
    </div>
  );
}

const AppWrap = styled.div`
  width: 100vw;
  height: 60vh;
  
  .inputbox{
    border: none; 
    background: transparent;
    text-align:center;
  }
  .inputcenter{
    margin-left:670px;
    position:absolute;
  }

  .appContentWrap {
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%)
    position: absolute;
    
    padding: 200px;
    text-align:center;
    background:url(./Maldives.jpg)
    
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
