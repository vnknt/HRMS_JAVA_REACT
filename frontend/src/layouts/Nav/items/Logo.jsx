import React from 'react'
import { Link } from 'react-router-dom'
export default function Logo(props) {
    return (
      
            <Link className={`navbar-brand ${props.className}`}  to="/" >{props.children}</Link>

    )
}
