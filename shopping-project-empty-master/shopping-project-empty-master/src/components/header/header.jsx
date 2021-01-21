import React, { useState, useEffect } from 'react'
import './header.scss'
// import './style.js'
import { Link } from "react-router-dom"
import classNames from 'classnames'
import ReactDOM from 'react-dom';
import Logo from 'assets/images/logo.png'
import User from 'assets/images/user.png'
import { SearchIcon, CartIcon, CaretDownIcon, BarsIcon, CloseIcon, PlusIcon } from 'components/icons/icons'

export const Header = () => {

  useEffect(() => {
  }, [])


  return (
    <div className="header">

      <div className="header__content">

        <div className="burgerMenu">
          <input type="checkbox" class="openSidebarMenu" id="openSidebarMenu" />
          <label for="openSidebarMenu" class="sidebarIconToggle">
            <div class="spinner diagonal part-1"></div>
            <div class="spinner horizontal"></div>
            <div class="spinner diagonal part-2"></div>
          </label>
          <div id="sidebarMenu">
            <ul class="sidebarMenuInner">
              <li>Hanoi <span>Vascara</span></li>
              <li><a href="">GIÀY</a></li>
              <li><a href="">TÚI XÁCH</a></li>
              <li><a href="">BALO</a></li>
              <li><a href="">VÍ BÓP</a></li>
              <li><a href="">DÉP & GUỐC</a></li>
              <li><a href="">PHỤ KIỆN</a></li>
              <li><a href="">GIFTCARD</a></li>
              <li><a href="">SALE OFF</a></li>
              <li><a href="">NEW ARRIVAL</a></li>
              <li><a href="">SUMMER KISSES</a></li>
              <li><a href="">TIN TỨC</a></li>
              <li>
                <div className="d-flex">
                  <p><a>Login / </a></p>
                  <p><a>Register</a></p>
                </div>
              </li>
            </ul>
          </div>
        </div>
        <div className="header__content-logo">
          <img src={Logo} alt="" />
        </div>
        <div className="header__content-dropdown__ship">
          <p>Chọn kho giao hàng</p>
          <select name="Ha noi" id="">
            <option value="Ho Chi Minh">Hà Nội</option>
            <option value="Hai Phong">Hai Phong</option>
            <option value="Da Nang">Da Nang</option>
          </select>
        </div>
        <div className="header__content-search_bar">

          <div className="header__content-search_bar-input">
            <div className="header__content-search_bar-logo">
              <SearchIcon className="search-icon"></SearchIcon>
            </div>
            <input value="Tìm kiếm" type="text" />
          </div>
        </div>
        <div className="header__content-action">
          <div className="header__content-action-register">
            <a href="">ĐĂNG KÝ /</a>
          </div>
          <div className="header__content-action-login">
            <a href="">ĐĂNG NHẬP</a>
          </div>
        </div>
        <div className="header__content-cart">
          <div className="header__content-cart-icon">
            <CartIcon className="cart-icon"></CartIcon>
          </div>
          <div className="header__content-cart-counter">
            <p>(0)</p>
          </div>
        </div>
      </div>
      <div className="header__navbar" id="header__navbar">
        <ul>
          <li><a href="">GIÀY</a></li>
          <li><a href="">TÚI XÁCH</a></li>
          <li><a href="">BALO</a></li>
          <li><a href="">VÍ BÓP</a></li>
          <li><a href="">DÉP & GUỐC</a></li>
          <li><a href="">PHỤ KIỆN</a></li>
          <li><a href="">GIFTCARD</a></li>
          <li><a href="">SALE OFF</a></li>
          <li><a href="">NEW ARRIVAL</a></li>
          <li><a href="">SUMMER KISSES</a></li>
          <li><a href="">TIN TỨC</a></li>
        </ul>
      </div>
     
    </div>

  )



}


