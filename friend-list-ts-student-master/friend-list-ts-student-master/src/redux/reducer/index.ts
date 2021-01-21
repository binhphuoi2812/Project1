import { combineReducers } from "redux";
import { ModalFriend } from "redux/reducer/modal";
import { DataFriends } from "redux/reducer/data-friends";

export const RootReducer = combineReducers({
  ModalFriend,
  DataFriends,
});

export type RootState = ReturnType<typeof RootReducer>;
