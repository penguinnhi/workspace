
import { configureStore } from "@reduxjs/toolkit";
import { numReducter } from "./numState";
import { memberReducer } from "./memberState";


// 모든 state변수를 저장하는 저장소

const store=configureStore({
  reducer : {
    numState : numReducter,
    memberState : memberReducer
  }
})

export default store;