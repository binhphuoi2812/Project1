import React, { useEffect } from 'react'
import './category.scss'
import { CategorySection } from 'components/category-section/category-section'
import { Link } from 'react-router-dom'
import mockupDataDiscount from 'data/mockupDataDiscount'
import mockupDataBestSeller from 'data/mockupDataBestSeller'
import mockupDataHot from 'data/mockupDataHot'
import { connect } from 'react-redux'
import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";
import { ProductHot, Product, ProductBestSeller, ProductDiscount } from 'components/product/product'
import { ProductDetail } from 'routes/product-detail/product-detail'
import { useDispatch, useSelector } from "react-redux";


const Category = ({ match, mockupDataNewest }) => {

  const ProductNewest = useSelector(state => state.mockupDataCategory)
  const ProductDiscount = useSelector(state => state.mockupDataCategoryDiscount)
  const ProductHot = useSelector(state => state.mockupDataCategoryHot)
  const ProductBestSeller = useSelector(state => state.mockupDataCategoryBestSeller)

  const banner = [
    require('assets/images/category-image-1.png'),
    require('assets/images/category-image-2.png'),
    require('assets/images/category-image-3.png'),
    require('assets/images/category-image-4.png')
  ]
  const currentCategory = match.params.category

  useEffect(() => {
    console.log(currentCategory)
  }, [])

  // return <div className="category">Category</div>;
  return (
    <div className="category">


      <Router>



        <Route path="/category/hot-newest" >
          <div className="category-banner">
            <img src={banner[0]} alt="" />
          </div>
          <div className="category-wrap">
            <h2 className="title-block">SẢN PHẨM MỚI NHẤT</h2>
            <Product data ={ProductNewest}></Product>
          </div>

          <div className="category-footer">
            <a className="see-more-category" href="/">
              Xem thêm các sản phẩm khác
            </a>
          </div>
        </Route>



        <Route path="/category/best-seller"  >
          <div className="category-banner">
            <img src={banner[1]} alt="" />
          </div>
          <div className="category-wrap">
            <h2 className="title-block">SẢN PHẨM BÁN CHẠY</h2>
            <Product data ={ProductBestSeller}></Product>
          </div>
          <div className="category-footer">
            <a className="see-more-category" href="/">
              Xem thêm các sản phẩm khác
            </a>
          </div>
        </Route>
        <Route path="/category/discount"  >
          <div className="category-banner">
            <img src={banner[2]} alt="" />
          </div>
          <div className="category-wrap">
            <h2 className="title-block">SẢN PHẨM KHUYẾN MÃI</h2>
            <Product data ={ProductDiscount}></Product>
          </div>
          <div className="category-footer">
            <a className="see-more-category" href="/">
              Xem thêm các sản phẩm khác
            </a>
          </div>
        </Route>

        <Route path="/category/hot" >
          <div className="category-banner">
            <img src={banner[3]} alt="" />
          </div>
          <div className="category-wrap">
            <h2 className="title-block">SẢN PHẨM NỔI BẬT</h2>
            <Product data ={ProductHot}></Product>
          </div>
          <div className="category-footer">
            <a className="see-more-category" href="/">
              Xem thêm các sản phẩm khác
            </a>
          </div>

        </Route>

        <Route path="/product-detail" exact component={ProductDetail}>


        </Route>

      </Router>
    </div>
  );
}

export default Category;
