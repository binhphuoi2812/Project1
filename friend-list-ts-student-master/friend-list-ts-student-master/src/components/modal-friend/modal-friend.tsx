import React, { useState, useEffect } from "react";
import "./modal-friend.scss";
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../redux/reducer/index";
import { closeModal, addFriend, editFriend } from "redux/action";
import {
  Modal,
  Button,
  Form,
  FormGroup,
  ControlLabel,
  HelpBlock,
  Input,
} from "rsuite";
import { UserPlusIcon, EditIcon } from "components/icons/icons";

type dataFriend = Array<{
  id: number;
  name: string;
  address: string;
  phoneNumber: string;
}>;

type Props = {
  typeModal: string;
  isActive: boolean;
  friendID: number;
  dispatch: any;
  dataFriends: dataFriend;
};

const ModalFriend = () => {
  const dispatch = useDispatch();
  const [dataName, setDataName] = useState("");
  const [dataAddress, setDataAddress] = useState("");
  const [dataPhoneNumber, setDataPhoneNumber] = useState("");

  const typeModal: string = useSelector(
    (state: RootState) => state.ModalFriend.typeModal
  );

   const friendID: number = useSelector(
     (state: RootState) => state.ModalFriend.friendID
   );
   const isActive: boolean = useSelector(
     (state: RootState) => state.ModalFriend.isActive
   );
   const dataFriends: dataFriend = useSelector(
     (state: RootState) => state.DataFriends
   );

  const close = () => {
    dispatch(closeModal());
  };

  useEffect(() => {
    if (typeModal === "edit") {
      setDataName(dataFriends[friendID - 1].name);
      setDataAddress(dataFriends[friendID - 1].address);
      setDataPhoneNumber(dataFriends[friendID - 1].phoneNumber);
    }
    console.log("run");
  }, [dataFriends, friendID, isActive, typeModal]);

  const submit = () => {
    if (typeModal === "add") {
      close();
      dispatch(addFriend(dataName, dataAddress, dataPhoneNumber));
      setDataName("");
      setDataAddress("");
      setDataPhoneNumber("");
    }
    if (typeModal === "edit") {
      close();
      dispatch(editFriend(friendID, dataName, dataAddress, dataPhoneNumber));
      setDataName("");
      setDataAddress("");
      setDataPhoneNumber("");
    }
  };

  return (
    <div className="modal-friend">
      <Modal backdrop={true} show={isActive} onHide={close}>
        <Modal.Header>
          {typeModal === "add" && (
            <Modal.Title>
              <UserPlusIcon />
              Add Friend
            </Modal.Title>
          )}
          {typeModal === "edit" && (
            <Modal.Title>
              <EditIcon />
              Edit Friend
            </Modal.Title>
          )}
        </Modal.Header>
        <Modal.Body>
          <Form
            onKeyPress={(e: any) => {
              if (e.key === "Enter") submit();
            }}
          >
            <FormGroup>
              <ControlLabel>Name</ControlLabel>
              <Input
                onChange={(value) => {
                  setDataName(value);
                }}
                value={dataName}
                name="name"
                type="text"
              />
              <HelpBlock tooltip>Required</HelpBlock>
            </FormGroup>
            <FormGroup>
              <ControlLabel>Address</ControlLabel>
              <Input
                onChange={(value) => {
                  setDataAddress(value);
                }}
                value={dataAddress}
                name="name"
                type="text"
              />
              <HelpBlock tooltip>Required</HelpBlock>
            </FormGroup>
            <FormGroup>
              <ControlLabel>Phone Number</ControlLabel>
              <Input
                onChange={(value) => {
                  setDataPhoneNumber(value);
                }}
                value={dataPhoneNumber}
                name="name"
                type="text"
              />
              <HelpBlock tooltip>Required</HelpBlock>
            </FormGroup>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          {typeModal === "add" && (
            <Button onClick={submit} appearance="primary">
              Add Friend
            </Button>
          )}
          {typeModal === "edit" && (
            <Button onClick={submit} appearance="primary">
              Save
            </Button>
          )}
          <Button onClick={close} appearance="subtle">
            Cancel
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default ModalFriend;
