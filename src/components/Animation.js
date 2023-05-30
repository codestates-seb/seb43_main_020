import React, { useRef, useState } from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import "swiper/css";
import "swiper/css/effect-coverflow";
import "swiper/css/pagination";
import "swiper/css/navigation";
import "./styles.css";

import { EffectCoverflow, Pagination, Navigation, Autoplay } from "swiper";

function Animation() {
  return (
    <Swiper
      // style={{ background: "url(/F.jpg)" }}
      spaceBetween={30}
      autoplay={{
        delay: 1000,
        disableOnInteraction: false,
      }}
      effect={"coverflow"}
      grabCursor={true}
      centeredSlides={true}
      loop={true}
      slidesPerView={"auto"}
      coverflowEffect={{
        rotate: 0,
        stretch: 0,
        depth: 50,
        modifier: 2.0,
      }}
      modules={[Autoplay, EffectCoverflow, Pagination]}
      className="mySwiper"
      pagination={{
        clickable: true,
      }}
    >
      <SwiperSlide>
        <img src="/weather1.jpg" alt="slide_image" />
      </SwiperSlide>
      <SwiperSlide>
        <img src="/weather2.JPG" alt="slide_image" />
      </SwiperSlide>
      <SwiperSlide>
        <img src="/weather3.JPG" alt="slide_image" />
      </SwiperSlide>
      <SwiperSlide>
        <img src="/weather4.jpg" alt="slide_image" />
      </SwiperSlide>
      <SwiperSlide>
        <img src="/weather5.JPG" alt="slide_image" />
      </SwiperSlide>
    </Swiper>
  );
}

export default Animation;
