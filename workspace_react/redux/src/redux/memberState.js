import { createSlice } from "@reduxjs/toolkit"

// 회원 정보 초기값 세팅
const initMember = {
  memId : '',
  memName : '',
  memAge : 0
}

const memberSlice = createSlice({
  name : 'member',
  initialState : initMember,
  reducers : {
    changeMemberInfo : (state,action) => {
      state.memId = action.payload.memId
      state.memName = action.payload.memName
      state.memAge = action.payload.memAge
    },
    changeMemberName : (state,action) => {
      state.memName = action.payload
    }
  }
})

export const memberActions = memberSlice.actions
export const memberReducer = memberSlice.reducer
