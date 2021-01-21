import React, { useState } from 'react'
import './homepage-carousel.scss'
import AliceCarousel from 'react-alice-carousel'
import { AngleLeftIcon, AngleRightIcon } from 'components/icons/icons'

export const HomepageCarousel = () => {
  const [currentIndex, setcurrentIndex] = useState(0)
  const [dataBanner] = useState([
    require('assets/images/image-slider-1.png'),
    require('assets/images/image-slider-2.png'),
    require('assets/images/image-slider-3.png'),
    require('assets/images/image-slider-4.png'),
    require('assets/images/image-slider-5.png'),
  ])

  const onSlideChanged = (e) => {
    setcurrentIndex(e.item)
  }
  
  return (
    <div className="homepage-carousel">
      <AliceCarousel autoPlay={true} autoPlayInterval={2000} buttonsDisabled={true} slideToIndex={currentIndex} onSlideChanged={onSlideChanged}>
        {dataBanner.length !== 0 && dataBanner.map((item) => <img key={item} src={item} alt="" />)}
      </AliceCarousel>
      <div className="carousel-btn carousel-prev" onClick={() => {setcurrentIndex(currentIndex - 1)}}><AngleLeftIcon /></div>
      <div className="carousel-btn carousel-next" onClick={() => {setcurrentIndex(currentIndex + 1)}}><AngleRightIcon /></div>
    </div>
  )
}
