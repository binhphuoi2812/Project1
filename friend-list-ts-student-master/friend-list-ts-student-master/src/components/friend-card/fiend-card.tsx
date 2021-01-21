import React from "react";
import "./friend-card.scss";
import { useDispatch } from "react-redux";
import { openModalEdit, deleteFriend } from "redux/action";
import { Button } from "rsuite";
import {
  PhoneIcon,
  AddressIcon,
  UserIcon,
  EditIcon,
  TrashIcon,
} from "components/icons/icons";

type Props = {
  id: number;
  name: string;
  address: string;
  phoneNumber: string;
};

const FriendCard = ({ id, name, address, phoneNumber }: Props) => {
  const dispatch = useDispatch();

  return (
    <div className="fiend-card">
      <div className="fiend-card-content">
        <div className="d-flex align-items-center mb-4">
          <div className="avatar">
            <UserIcon />
          </div>
          <h2 className="name">{name}</h2>
        </div>
        <p className="address">
          <AddressIcon />
          {address}
        </p>
        <p className="phone-number d-flex align-items-center">
          <PhoneIcon />
          {phoneNumber}
        </p>
        <div className="button-group d-flex justify-content-end">
          <Button
            color="green"
            onClick={() => dispatch(openModalEdit("edit", id))}
          >
            <EditIcon />
            Edit
          </Button>
          <Button color="red" onClick={() => dispatch(deleteFriend(id))}>
            <TrashIcon />
            Delete
          </Button>
        </div>
      </div>
    </div>
  );
};

export default FriendCard;
