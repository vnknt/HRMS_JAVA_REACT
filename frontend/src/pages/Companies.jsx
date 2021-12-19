import {React,useEffect,useState} from 'react'
import EmployerService from '../services/employerService'
import EmployerService from '../services/employerService'
export default function Companies() {

    let [companies,setCompanies] = useState([])

    useEffect(()=>{

        let employerService = new EmployerService()
        
        employerService.getEmployers().then((result)=>setCompanies(result.data.data))
            
    }


    )


    return (
        <div>
            
        </div>
    )
}
