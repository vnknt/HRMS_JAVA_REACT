import {React,useState,useEffect} from 'react'

import {  Navbar, NavDropdown } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import Logo from './items/Logo'
import NavbarItem from './items/NavbarItem'
import  ToggleButton  from './items/ToggleButton'
import styles from './index.module.css'
import { useDispatch, useSelector } from 'react-redux'
import { login, logout } from '../../store/actions/userAction'
import { useHistory } from 'react-router-dom'

export default function Nav() {
  const isUserLoggedIn = useSelector((state) => state.user)


  const user = useSelector(state => state.user)
  const dispatch = useDispatch();
  const history = useHistory()

  const [role, setRole] = useState(null)

  const handleLogin = ()=>{

    history.push("/login")
    
  }

useEffect(() => {
  let r = localStorage.getItem("role")
  setRole(r)

}, [isUserLoggedIn])


  const handleLogout=()=>{
    history.push("/login")
    
    dispatch(logout())
    setRole(null)
  }

  return (

    <div className="navbar fixed-top navbar-expand-lg navbar-dark bg-dark p-3">
      <div className="container-fluid">
        <Logo className="me-4 d-none d-sm-block">PROJECT HRMS</Logo>
        <Logo className="me-4 d-block d-sm-none">HRMS</Logo>
        


        <div className="d-flex   mb-2 mb-lg-0 col-7 col-md-5 col-lg-3  ">
            <input className="form-control  me-1 " type="search" placeholder="Search"  />
            <button className="btn btn-outline-light" type="submit"><i class="fas fa-search"></i></button>
          </div>
          <ToggleButton/>
        
        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">


          <ul className="navbar-nav ms-auto">


            <NavbarItem className="me-2" to="/">Ana Sayfa</NavbarItem>
            <NavbarItem className="me-2" to="/job-adverts" >İlanlar</NavbarItem>
            {
              role==="EMPLOYER"?
              <NavbarItem className="me-2" to="/job-advert/add" >Yeni İlan</NavbarItem>
              :""
          
          }
          
          {
              role==="SYSTEM_USER"?
            <NavbarItem className="me-2" to="/job-adverts/confirm">Onay Sayfası</NavbarItem>
            :""}
            {
              user
              ?<button className="btn btn-danger" onClick={()=>handleLogout()}>Çıkış Yap</button>
              : <button className="btn btn-success" onClick={()=>handleLogin()}>Giriş Yap</button>
            }
            
            

          </ul>
         

        </div>
      </div>
    </div>
  )
}
