import React from 'react'
import {useSelector} from 'react-redux'
export default function Home() {

    const user = useSelector(state => state.user)


    return (
        <div>
            {
                user.loginState
                    ?"Giriş Yapıldı..."
                    :"Lütfem giriş yapınız"
               
            }
        </div>
    )
}
