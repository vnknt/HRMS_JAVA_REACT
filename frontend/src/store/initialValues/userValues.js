export const loginState=false;
export const role=null
export const accessToken = (localStorage.getItem('accessToken'))
export const refreshToken=(localStorage.getItem('refreshToken'))

export const userLoggedIn = accessToken==null||accessToken===undefined ?false:true