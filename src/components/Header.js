import React, { Fragment } from "react";
import Animation from "../components/Animation";
import { BsGoogle } from "react-icons/bs";
import { FaFacebookSquare } from "react-icons/fa";
import { SiNaver } from "react-icons/si";
import App from "../components/Weather";
import Alert from "../components/Alert";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";

function Header() {
  return (
    <div>
      <>
        <div id="banner">
          <div className="container">
            <div className="row">
              <div className="padding1" style={{ marginTop: "-100px" }}>
                <Animation />
              </div>
            </div>
          </div>
        </div>
        <section id="features">
          <div className="container">
            <div className="row">
              <div className="col-3 col-6-medium col-12-small">
                <section>
                  <a href="#" className="bordered-feature-image">
                    <img src="assets/imagess/pic01.jpg" alt="" />
                  </a>
                  <h2>
                    <strong>오늘의날씨</strong>
                    <p>날씨정보를 제공합니다</p>
                  </h2>
                  <p>This site site,provides free weather information</p>
                </section>
              </div>
              <div className="col-3 col-6-medium col-12-small">
                <section>
                  <a href="#" className="bordered-feature-image">
                    <img src="assets/imagess/pic02.jpg" alt="" />
                  </a>
                  <h2>원하는 지역을 검색창에 입력하면 정보를 제공합니다</h2>
                  <p>How to use</p>
                  <p>
                    Fill in the desired region and we will provide you with
                    information
                  </p>
                </section>
              </div>
              <div className="col-3 col-6-medium col-12-small">
                <section>
                  <a href="#" className="bordered-feature-image">
                    <img src="assets/imagess/pic03.jpg" alt="" />
                  </a>
                  <h2>License Info</h2>
                  <p></p>
                </section>
              </div>
              <div className="col-3 col-6-medium col-12-small">
                <section>
                  <a href="#" className="bordered-feature-image">
                    <img src="assets/imagess/pic04.jpg" alt="" />
                  </a>
                  <h2>쉽게 날씨정보를 얻어보세요</h2>
                  <p>Get weather information easily</p>
                </section>
              </div>
            </div>
          </div>
        </section>
        <section id="content">
          <div>
            <App />
          </div>
        </section>
      </>
    </div>
  );
}
export default Header;
