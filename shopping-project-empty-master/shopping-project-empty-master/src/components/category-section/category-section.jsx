import React from 'react'
import './category-section.scss'

// import AliceCarousel from 'react-alice-carousel'
import 'react-alice-carousel/lib/alice-carousel.css';

import { Link } from 'react-router-dom'
import { CarouselBestSeller, CarouselProductDiscount, CarouselProductHot, Product,CarouselProduct } from 'components/product/product'
// import { AngleRightIcon } from 'components/icons/icons'
import { useDispatch, useSelector } from "react-redux";




export const CategorySection = ({ title, link, dataProduct, isSlider }) => {
  const ProductNewest = useSelector(state => state.mockupDataCategory)
  const ProductDiscount = useSelector(state => state.mockupDataCategoryDiscount)
  const ProductHot = useSelector(state => state.mockupDataCategoryHot)
  const ProductBestSeller = useSelector(state => state.mockupDataCategoryBestSeller)

  return <div className="category-section section-wrap">
    <div className="category-section__new">
      <h2 className="title-block">SẢN PHẨM MỚI NHẤT</h2>
      <Link to="/category/hot-newest">Xem tất cả</Link>
      <div className="category-section__new-main">
        <Product data={ProductNewest}></Product>
      </div>
    </div>
    <div className="category-section__sale">
      <h2 className="title-block">SẢN PHẨM KHUYẾN MÃI</h2>
      <Link to="/category/discount">Xem tất cả</Link>
      <div className="category-section__new-main">
        <CarouselProduct data= {ProductDiscount}></CarouselProduct>
      </div>
    </div>

    <div className="category-section__sale">
      <h2 className="title-block">SẢN PHẨM BÁN CHẠY</h2>
      <Link to="/category/best-seller">Xem tất cả</Link>
      <div className="category-section__new-main">
      <CarouselProduct data= {ProductBestSeller}></CarouselProduct>
      </div>
    </div>

    <div className="category-section__sale">
      <h2 className="title-block">SẢN PHẨM NỔI BẬT</h2>
      <Link to="/category/hot">Xem tất cả</Link>
      <div className="category-section__new-main">
      <CarouselProduct data= {ProductHot}></CarouselProduct>
      </div>
    </div>
  </div>;
}
