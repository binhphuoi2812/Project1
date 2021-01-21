import React from 'react'
import './app.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'rsuite/dist/styles/rsuite-default.css'

import Header from 'components/header/header'
import FriendLists from 'components/friend-lists/friend-lists'
import ModalFriend from 'components/modal-friend/modal-friend'

import { createStore } from 'redux';
import { Provider } from 'react-redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { RootReducer } from 'redux/reducer';

const store = createStore(
  RootReducer,
  composeWithDevTools(),
)

const App = () => {
  return (
    <Provider store={store}>
      <div className="app">
        <Header />
        <FriendLists />
        <ModalFriend />
      </div>
    </Provider>
  )
}

export default App
