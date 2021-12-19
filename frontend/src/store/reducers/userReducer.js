import {loginState} from  '../initialValues/userValues';
import Actions from '../actions/constants';


const initialState={

    loginState:loginState

};

export function userReducer(state=initialState,action){


    switch(action.type){
        
        case Actions.USER_LOGIN:
            state.loginState=true;

            return{ ...state}


        case Actions.USER_LOGOUT:
            state.loginState=false;
            return {...state}


        default:
            return state

    }




}