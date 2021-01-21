import React, { useEffect } from 'react'
import './home.scss'
import Gif from 'assets/images/banner-gif.gif'
import mockupDataDiscount from 'data/mockupDataDiscount'
import mockupDataBestSeller from "data/mockupDataBestSeller";
// import mockupDataHot from "data/mockupDataHot";
import { HomepageCarousel } from "components/homepage-carousel/homepage-carousel"
// import { Product } from 'components/product/product';
import { CategorySection } from 'components/category-section/category-section';

const Homepage = () => {
  useEffect(() => {
    console.log(mockupDataBestSeller);
  }, [])
  console.log(mockupDataDiscount);
  return <div className="homepage">
    <HomepageCarousel></HomepageCarousel>
    <div className="home-page__title">
      <h2 className="title-block">HOT TREND 2020</h2>
      <img src={Gif} alt="" />
    </div>
    <CategorySection></CategorySection>
  </div>;
}

export default Homepage;