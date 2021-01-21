
import React , {useEffect}from "react";
import "./product-card.scss";
import { useDispatch } from "react-redux";
import mockupData from "data/mockupDataNewest";
import mockupDataHot from "data/mockupDataHot";
import mockupDataDiscount from 'data/mockupDataDiscount'


type Props = {
    image: any;
    price: number;
    sale: number;
    title: string;
    status: {
        type: string,
        content: string,
    }
};

const ProductCard = ({ image, price, sale, title, status }: Props) => {
    // const dispatch = useDispatch();
    useEffect(() => {
        console.log(mockupDataDiscount);
      }, [])
    return (
        <div className="product">
            <div className="product-image">
                <img src={image} alt="" />
            </div>
            <div className="product-price">
                <p className="price">{price}</p>
            </div>
            <h2 className="product-title">{title}</h2>
            {/* <div className="price-status">{status.content}</div> */}

        </div>
    );
};

export default ProductCard;
