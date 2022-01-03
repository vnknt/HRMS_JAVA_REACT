import {loginState,role, userLoggedIn} from  '../initialValues/userValues';
import Actions from '../actions/constants';
import jwt_decode from 'jwt-decode';
const initialState = userLoggedIn

export function userReducer(state=initialState,{type,payLoad}){


    switch(type){

        case Actions.USER_LOGIN:
            console.log(payLoad)
            localStorage.setItem("accessToken",payLoad.accessToken)
            let token = payLoad.accessToken
            let token_decoded = jwt_decode(token)
            localStorage.setItem("role",token_decoded.roles[0].authority)
            localStorage.setItem("user_id",token_decoded.id)
            return true
            
        case Actions.USER_LOGOUT:
            localStorage.removeItem("accessToken")
            localStorage.removeItem("role")
            return false

        // case "LOGOUT":
        //     let userService = new UserService()
        //     let result = userService.logout().then((result=>{
        //         console.log(result.data)
        //         localStorage.removeItem("accessToken")
        //         localStorage.removeItem("refreshToken")
            
        //     }))        
        //     localStorage.removeItem("accessToken")
        //     localStorage.removeItem("refreshToken")
            
        //     console.log("logout")
        //     return false

        // case "CLEAR_USER_STATE":
        //     localStorage.removeItem("accessToken")
        //     localStorage.removeItem("refreshToken")
        //     return false

        
        // case "REFRESH_TOKENS":
        //     console.log("refresh")
        //     localStorage.setItem("accessToken",payLoad.accessToken)
        //     localStorage.setItem("refreshToken",payLoad.refreshToken)
        //     return true
        default:
            return state
    }





}