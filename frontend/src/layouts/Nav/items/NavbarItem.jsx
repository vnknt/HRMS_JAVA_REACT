import React from 'react'
import { Link } from 'react-router-dom'
export default function NavbarItem(props) {

    return (
      
            <li className="nav-item">
                <Link to={props.to} className={`nav-link  ${props.className}`} aria-current="page" >{props.children}</Link>
            </li>
       
    )
}
