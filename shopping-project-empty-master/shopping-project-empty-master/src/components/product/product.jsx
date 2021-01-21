import React from 'react'
import './product.scss'
import { Link } from 'react-router-dom'
// import ProductCard from 'components/product-card/product-card'
import {  useSelector } from "react-redux";
// import mockupDataNewest from "data/mockupDataNewest";
import AliceCarousel from 'react-alice-carousel'
import "react-alice-carousel/lib/scss/alice-carousel.scss";
// import { ProductDetail } from 'routes/product-detail/product-detail'

export const Product = ({data}) => {
  console.log(data)
  return (
    <div className="list-product">
      {data && data.map((item, index) =>
        <div className="product-item" key={index}>
          <Link to="/product-detail" >
            
            <div className="product">
              <div className="product-image">
                <img src={item.image} alt="" />
              </div>
              <div className="product-price">
                <p className="price">{item.price}</p>
              </div>
              <h2 className="product-title">{item.title}</h2>
              <div className="price-status">{item.status.content}</div>

            </div>
          </Link>
        </div>)}
    </div>
  );
}






export const CarouselProduct = ({data}) => {
  const handleDragStart = (e) => e.preventDefault();
  const responsive = {
    0: { items: 1 },
    568: { items: 2 },
    1024: { items: 4 },
  };

  var items = []
  data && data.map((item, index) => <div className="list-product-carousel" key={index}>
    {items = [...items,
    <div className="product-item" onDragStart={handleDragStart}>
      <Link to="/product-detail">
       
        <div className="product">
          <div className="product-image">
            <img src={item.image} alt="" />
          </div>
          <div className="product-price">
            <p className="price">{item.price}</p>
          </div>
          <h2 className="product-title">{item.title}</h2>
          <div className="price-status">{item.status.content}</div>

        </div>
      </Link>
    </div>,]

    }

  </div>)
  return (

    <AliceCarousel className="alice-carousel" mouseTracking items={items} responsive={responsive} >

    </AliceCarousel>
    
  );
}

