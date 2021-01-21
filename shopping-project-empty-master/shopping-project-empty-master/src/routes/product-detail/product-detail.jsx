import React, { useState, useEffect } from 'react'
import './product-detail.scss'
// import './switch-tab.js'
import { Link } from 'react-router-dom'
import classNames from 'classnames'
import { DeliveryIcon, CallIcon, PaymentIcon, GuardIcon, ReturnIcon } from 'components/icons/icons'
import { CategorySection } from 'components/category-section/category-section'
import OtherProduct1 from 'assets/images/product-detail-6.jpg'
import OtherProduct2 from 'assets/images/product-detail-7.jpg'
import OtherProduct3 from 'assets/images/product-detail-8.jpg'
import SizeTutorial from 'assets/images/size-tutorial.png'
import mockupDataHot from 'data/mockupDataHot'
import { CarouselProduct } from 'components/product/product'
import { useDispatch, useSelector } from 'react-redux'
import $ from "jquery"

export const ProductDetail = () => {
  const count = useSelector(state => state.counterReducer.counter)
  const ProductHot = useSelector(state => state.mockupDataCategoryHot)
  const dispatch = useDispatch();
  const [imageProduct] = useState([
    require('assets/images/product-detail-1.jpg'),
    require('assets/images/product-detail-2.jpg'),
    require('assets/images/product-detail-3.jpg'),
    require('assets/images/product-detail-4.jpg'),
    require('assets/images/product-detail-5.jpg'),
  ])
  const [size, setSize] = useState(0)
  const [amount, setAmount] = useState(1)
  const [currentTab, setCurrentTab] = useState(1)

  useEffect(() => {
    window.scrollTo(0, 0)
  }, [])

  
  return <div className="product-detail">
    <div className="section-wrap">
      <div className="quick-link">
        <a href="">Trang chủ</a>
        <a href="">Giày</a>
        <a href="">Giày Bít</a>

      </div>
      <div className="product-main">
        <div className="product-item">
          <div className="product-image">
            <img src={imageProduct[0]} alt="" />
          </div>
          <div className="product-image">
            <img src={imageProduct[1]} alt="" />
          </div>
          <div className="product-image">
            <img src={imageProduct[2]} alt="" />
          </div>
          <div className="product-image">
            <img src={imageProduct[3]} alt="" />
          </div>
          <div className="product-image">
            <img src={imageProduct[4]} alt="" />
          </div>
        </div>

        <div className="product-item">
          <div>
            <h2 className="title">Giày Bít Mũi Nhọn Satin Phối Nơ - BMN 0418 - Màu Hồng</h2>
            <div className="product-status">NEW</div>
            <div className="price">545.000 ₫</div>
            <h6 className="size-title">Kích cỡ | <span>Tất cả</span></h6>
            <div className="size d-flex flex-wrap">
              <div className="size-block out-of-stock">35</div>
              <div className="size-block">36</div><div className="size-block">37</div>
              <div className="size-block">38</div><div className="size-block">39</div>
            </div>
            <h6 className="size-title">Số lượng</h6>
            <div className="amount">
              <button onClick={() => dispatch({ type: "INCREMENT_SUB" })}> <span className="minus">-</span></button>
              <span className="value">{count}</span>
              <button onClick={() => dispatch({ type: "INCREMENT_COUNT" })}> <span className="plus">+</span></button>
            </div>
            <h6>Sản phẩm cùng loại khác màu</h6>
            <div className="other-product d-flex flex-wrap">
              <a className="other-product-item" href="/">
                <img src={OtherProduct1} alt="" />
              </a>
              <a className="other-product-item" href="/">
                <img src={OtherProduct2} alt="" />
              </a>
              <a className="other-product-item" href="/">
                <img src={OtherProduct3} alt="" />
              </a>
            </div>

            <div className="endow">
              <div className="endow-item d-flex">
                <DeliveryIcon></DeliveryIcon>
                <p>Sử dụng ngay <span>coupon freeship</span> để được giảm ngay 30K phí vận chuyển. Xem chi tiết</p>
              </div>
              <div className="endow-item d-flex">
                <CallIcon></CallIcon>
                <p><span>1800 6909</span> Hotline đặt hàng (Miễn cước, 8h30 - 22h)</p>
              </div>
              <div className="endow-item d-flex">
                <DeliveryIcon></DeliveryIcon>
                <p>Giao hàng nhanh trên toàn quốc</p>
              </div>
              <div className="endow-item d-flex">
                <PaymentIcon></PaymentIcon>
                <p>Thanh toán tiện lợi với nhiều hình thức</p>
              </div>
              <div className="endow-item d-flex">
                <GuardIcon></GuardIcon>
                <p>Bảo hành sản phẩm trọn đời (trừ mắt kính, thắt lưng)</p>
              </div>
              <div className="endow-item d-flex">
                <ReturnIcon></ReturnIcon>
                <p>Miễn phí đổi sản phẩm trong 7 ngày (trừ mắt kính, thắt lưng)</p>
              </div>
            </div>
          </div>
        </div>

        <div className="product-item">
          <div className="tab">
            <div className="tab-header">
              <div className="tab-item active">THÔNG TIN CHI TIẾT</div>
              <div className="tab-item ">HƯỚNG DẪN CHỌN SIZE</div>
            </div>
            <div className="tab-main">
              <div className="tab-item active">
                <div className="line">
                  <h4>Mã sản phẩm</h4>
                  <p>1010BMN0418</p>
                </div>
                <div className="line">
                  <h4>Loại sản phẩm</h4>
                  <p>Giày Bít</p>
                </div>
                <div className="line">
                  <h4>Độ cao gót</h4>
                  <p>1 cm</p>
                </div>
                <div className="line">
                  <h4>Loại mũi</h4>
                  <p>Bít mũi nhọn</p>
                </div>
                <div className="line">
                  <h4>Chất liệu</h4>
                  <p>Satin</p>
                </div>
                <div className="line">
                  <h4>Hoa văn, chi tiết</h4>
                  <p>Một màu, đính nơ</p>
                </div>
                <div className="line">
                  <h4>Phù hợp sử dụng</h4>
                  <p>Đi làm, đi tiệc, đi chơi</p>
                </div>
              </div>
              <div className="tab-item">
                <img src={SizeTutorial} alt="" />
              </div>
            </div>
          </div>

          {
            document.addEventListener('DOMContentLoaded', function () {
              // タブに対してクリックイベントを適用
              const tabs = document.getElementsByClassName('tab');
              for (let i = 0; i < tabs.length; i++) {
                tabs[i].addEventListener('click', tabSwitch);
              }

              // タブをクリックすると実行する関数
              function tabSwitch() {
                // タブのclassの値を変更
                document.getElementsByClassName('active')[0].classList.remove('active');
                this.classList.add('active');
                // コンテンツのclassの値を変更
                document.getElementsByClassName('active')[0].classList.remove('active');
                const arrayTabs = Array.prototype.slice.call(tabs);
                const index = arrayTabs.indexOf(this);
                document.getElementsByClassName('panel')[index].classList.add('active');
              };
            })
          }
        </div>

      </div>
      <div className="category-section__sale">
        <h2 className="title-block">SẢN PHẨM NỔI BẬT</h2>
        <Link to="/category/hot">Xem tất cả</Link>
        <div className="category-section__new-main">
          <CarouselProduct data={ProductHot}></CarouselProduct>
        </div>
      </div>

    </div>


  </div>;
}




