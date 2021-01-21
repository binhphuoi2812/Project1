import React from 'react'
import './footer.scss'
import { Link } from 'react-router-dom'
import { HotlineIcon, MapMarkerIcon, BctIcon, FacebookIcon, InstagramIcon, PinterestIcon, YoutubeIcon, ZaloIcon, CashIcon, AtmIcon, VisaIcon, MomoIcon, ZalopayIcon } from 'components/icons/icons'

export const Footer = () => {
  return (
    <div className="footer">
      <div className="footer__details">
        <div className="footer__details-company">
          <h4>CÔNG TY</h4>
          <a href="">Giới thiệu</a>
          <a href="">Tuyển dụng</a>
        </div>
        <div className="footer__details-rule">
          <h4>CHÍNH SÁCH</h4>
          <a href="">Chính sách bảo mật</a>
          <a href="">Ưu đãi khách hàng thân thiết</a>
          <a href="">Chính sách bảo hành trọn đời</a>
          <a href="">Chính sách giao nhận</a>
          <a href="">Chính sách đổi sản phẩm</a>
        </div>
        <div className="footer__details-support" >
          <h4>HỖ TRỢ KHÁCH HÀNG</h4>
          <a href="">Hướng dẫn mua hàng</a>
          <a href="">Tra cứu bảo hành</a>
          <a href="">Quy định về phiếu quà tặng</a>
          <a href="">Điều khoản sử dụng</a>
        </div>
        <div className="footer__details-contact">
          <div className="footer__details-contact-network">
            <h4>KẾT NỐI VASCARA</h4>
            <div className="icon-network">
              <ul>
                <li>   <FacebookIcon></FacebookIcon></li>
                <li> <InstagramIcon></InstagramIcon></li>
                <li><PinterestIcon></PinterestIcon></li>
                <li><YoutubeIcon></YoutubeIcon></li>
                <li>   <ZaloIcon></ZaloIcon></li>
              </ul>





            </div>
          </div>
          <div className="footer__details-contact-payment">
            <h4>PHƯƠNG THỨC THANH TOÁN</h4>
            <div className="icon-payment">
              <ul>
                <li>  <CashIcon></CashIcon></li>
                <li> <AtmIcon></AtmIcon></li>
                <li><VisaIcon></VisaIcon></li>
                <li> <MomoIcon></MomoIcon></li>
                <li><ZalopayIcon></ZalopayIcon></li>
              </ul>





            </div>
          </div>
        </div>
      </div>

      <div className="second__information">
        <div className="permision">
          <BctIcon></BctIcon>
        </div>
        <div className="location">
          <MapMarkerIcon className="icon-import"></MapMarkerIcon>
          <a href="">Xem vị trí cửa hàng</a>
        </div>
        <div className="hotline">
          <HotlineIcon className="icon-import"></HotlineIcon>
          <a href="">1800 6909 </a>
          <p>(miễn phí, 9h - 22h)</p>
        </div>
      </div>
      <div className="copy-right">
        <p>Công ty TNHH MTV Global Fashion. Văn phòng: Lầu 4 tòa nhà ACM số 96 Cao Thắng phường 04 quận 03 TP Hồ Chí Minh.</p>
        <p>GP số 0314657558 do sở KHĐT Tp Hồ Chí Minh cấp lần đầu ngày 05/10/2017</p>
      </div>
    </div>

  )
}
