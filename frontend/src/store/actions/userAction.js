import React from 'react'
import Actions from './constants'

export function login(user){

    return({
        type:Actions.USER_LOGIN,
        payload:user
    })


}




export function logout(){
    return {
        type:Actions.USER_LOGOUT,
        payload:null
    }
}
