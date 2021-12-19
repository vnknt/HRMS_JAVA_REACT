import React, { useState, useEffect } from 'react'
import { Icon, Input, Label, Menu } from 'semantic-ui-react'
import CityService from "../../services/cityService"
import JobService from '../../services/jobService'
import CitySection from "./Sections/CitySection"
import PositionSection from './Sections/PositionSection'
import "./sidebar.css"

export default function Sidebar() {



  let [cities, setCities] = useState([])
  let [jobs , setJobs]  =useState([])

  useEffect(() => {

    let cityService = new CityService();
    let jobService = new JobService();


    cityService.getCities().then(result => {
      setCities(result.data.data)
    })

    jobService.getJobs().then(result=>{

      setJobs(result.data.data)

    })

  }, [])



  return (

    <div>
      <CitySection cities={cities}/>
      <PositionSection jobs={jobs}/>

      
    </div>
  )
}
