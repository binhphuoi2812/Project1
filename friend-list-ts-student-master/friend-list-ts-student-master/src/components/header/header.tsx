import React from "react";
import { Button } from "rsuite";
import "./header.scss";
import { PeopleIcon, UserPlusIcon } from "components/icons/icons";
import { useDispatch } from "react-redux";
import { openModal } from "redux/action";

type Props = {
  dispatch: any;
};

const Header = () => {
  const dispatch = useDispatch();
  return (
    <div className="header d-flex align-items-center justify-content-between">
      <div className="header-item">
        <PeopleIcon />
        Mah Friends
      </div>
      <div className="header-item d-flex align-items-center">
        <Button
          appearance="primary"
          onClick={() => {
            dispatch(openModal("add"));
          }}
        >
          <UserPlusIcon />
          ADD
        </Button>
      </div>
    </div>
  );
};
export default Header;
