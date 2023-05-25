import React, { Fragment } from "react";
import Animation from "../components/Animation";
import { BsGoogle } from "react-icons/bs";
import { FaFacebookSquare } from "react-icons/fa";
import { SiNaver } from "react-icons/si";
import App from "../components/Weather";
import Alert from "../components/Alert";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import Header from "../components/Header";
import Comment from "../components/Comment";

function Index() {
  let navigate = useNavigate();
  return (
    <Fragment>
      <div id="page-wrapper">
        <section id="header">
          <div className="container">
            <div className="row">
              <div className="col-12">
                <h1>
                  <a href="home" id="logo">
                    <img src="/weather.png" width="100px" height="50px" />{" "}
                    오늘의날씨
                  </a>
                </h1>

                <nav id="nav">
                  <a href="home">Home</a>
                  <a href="Alert">
                    <span
                      onClick={() => {
                        navigate("/Alert");
                      }}
                    >
                      Notice
                    </span>
                  </a>
                  {/* <a href="twocolumn1.html">Two Column #1</a>
                  <a href="twocolumn2.html">Two Column #2</a>
                  <a href="onecolumn.html">One Column</a> */}
                </nav>
              </div>
            </div>
          </div>
        </section>
        <Routes>
          <Route path="/home" element={<Header />} />
          <Route path="/" element={<Header />} />
          <Route path="/alert" element={<Comment />} />
        </Routes>

        <section id="footer">
          <div className="container">
            <div className="row">
              <div className="col-8 col-12-medium">
                <section>
                  <h2></h2>
                  <div>
                    <div className="row">
                      <div className="col-3 col-12-small">
                        <ul className="link-list last-child">
                          <li>
                            <a href="https://openweathermap.org/">
                              OpenWeather
                            </a>
                          </li>
                          <li>
                            <a href="https://openweathermap.org/">Get Api</a>
                          </li>
                        </ul>
                      </div>
                      <div className="col-3 col-12-small">
                        <ul className="link-list last-child">
                          <li>
                            <a href="https://www.naver.com">
                              <SiNaver />
                            </a>
                          </li>
                          <li>
                            <a href="https://www.naver.com">Naver</a>
                          </li>
                        </ul>
                      </div>
                      <div className="col-3 col-12-small">
                        <ul className="link-list last-child">
                          <li>
                            <a href="https://www.google.com">
                              <BsGoogle />
                            </a>
                          </li>
                          <li>
                            <a href="https://www.google.com">Google</a>
                          </li>
                        </ul>
                      </div>
                      <div className="col-3 col-12-small">
                        <ul className="link-list last-child">
                          <li>
                            <a href="https://www.facebook.com">
                              <FaFacebookSquare />
                            </a>
                          </li>
                          <li>
                            <a href="https://www.facebook.com">Facebook</a>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </section>
              </div>
              <div className="col-4 col-12-medium imp-medium">
                <section>
                  <h2>OpenWeatherMap api로 정보제공</h2>
                  <p>Provide information through OpenWeatherMap API</p>
                </section>
              </div>
            </div>
          </div>
        </section>

        <div id="copyright">&copy; Copyright | 오늘의날씨</div>
      </div>

      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/js/browser.min.js"></script>
      <script src="assets/js/breakpoints.min.js"></script>
      <script src="assets/js/util.js"></script>
      <script src="assets/js/main.js"></script>
    </Fragment>
  );
}

export default Index;
