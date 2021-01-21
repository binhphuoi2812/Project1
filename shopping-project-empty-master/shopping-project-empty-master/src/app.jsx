import React from 'react';
import 'rsuite/dist/styles/rsuite-default.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import './app.scss'
import './index.scss';
import Homepage from 'routes/home/home'
import { Header } from "components/header/header";
import { Footer } from "components/footer/footer";
import Category from 'routes/category/category'
import { ProductDetail } from 'routes/product-detail/product-detail'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import { RootReducer } from 'redux/reducer'

import {
  BrowserRouter as Router,
  Route,
} from "react-router-dom";

const store = createStore(
  RootReducer
)

const App = () => {
  return (
    <Provider store={store}>
      <Router>
        <div className="app">
          <Header />
          <Route path="/" exact component={Homepage} />
          <Route path="/category/:category" exact component={Category} />
          <Route path="/product-detail" exact component={ProductDetail} />
          <Footer />
          
        </div>
      </Router>
    </Provider>
  );
}

export default App;
