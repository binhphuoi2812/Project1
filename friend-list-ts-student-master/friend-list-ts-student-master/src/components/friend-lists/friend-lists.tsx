import React, { useState, useEffect } from "react";
import "./friend-lists.scss";
import FriendCard from "components/friend-card/fiend-card";
import { useSelector } from "react-redux";
import { FaceSadIcon } from "components/icons/icons";
import { RootState } from "../../redux/reducer/index";

type dataFriendsType = Array<{
  id: number;
  name: string;
  address: string;
  phoneNumber: string;
}>;

const FiendLists = () => {
  const dataFriends: dataFriendsType = useSelector(
    (state: RootState) => state.DataFriends
  );
  const [dataFriendsState, changeListState]: [dataFriendsType, any] = useState([]);

  useEffect(() => {
    changeListState(dataFriends);
  }, [dataFriends]);

  const handleInputSearch = (e: any) => {
    const friendFilter: dataFriendsType = dataFriends.filter(
      (item) =>
        item.name.toLowerCase().includes(e.target.value.toLowerCase()) ||
        item.address.toLowerCase().includes(e.target.value.toLowerCase()) ||
        item.phoneNumber.toLowerCase().includes(e.target.value.toLowerCase())
    );
    changeListState(friendFilter);
  };

  return (
    <div>
      <input className="filter-friends" onChange={handleInputSearch} placeholder="Filter friends"></input>
      <div className="list-friends d-flex flex-wrap ">
        {dataFriendsState.length === 0 && (
          <div className="list-null d-flex flex-md-column justify-content-center align-items-center">
            <FaceSadIcon />
            <p>
              Wahh.. Look like you don't have friend.. Let's add some friend now
              !
            </p>
          </div>
        )}
        {dataFriendsState.length > 0 &&
          dataFriendsState.map((item) => (
            <FriendCard
              key={item.id}
              id={item.id}
              name={item.name}
              address={item.address}
              phoneNumber={item.phoneNumber}
            />
          ))}
      </div>
    </div>
  );
};

export default FiendLists;
