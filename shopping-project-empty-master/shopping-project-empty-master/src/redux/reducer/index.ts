import { combineReducers } from 'redux';
import { mockupDataCategory, mockupDataCategoryBestSeller,mockupDataCategoryDiscount,mockupDataCategoryHot } from 'redux/reducer/category'
import {counterReducer} from 'redux/reducer/counterReducer'
export const RootReducer = combineReducers({
  mockupDataCategory,
  mockupDataCategoryBestSeller,
  mockupDataCategoryDiscount,
  mockupDataCategoryHot,
  counterReducer
})