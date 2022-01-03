import React from 'react'
import {useSelector} from 'react-redux'
export default function Home() {

    const user = useSelector(state => state.user)


    return (
        <div className='text-center'>
            <img  width="1000" src="https://media-exp1.licdn.com/dms/image/C4D22AQEnpvyfoUYjGg/feedshare-shrink_2048_1536/0/1623226486796?e=1643846400&v=beta&t=6ejpPtMY8KAoAzDydFWMq4MZKx7Ym7tMVpeWINNMX1w">
            </img>
        </div>
    )
}
