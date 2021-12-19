import React, { useState } from 'react'
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import JobAdvertService from '../services/jobAdvertService'
import FormTextInput from '../components/customForm/FormTextInput'
export default function JobAdvertDetail() {

    let {id} = useParams()

    
    const [jobAdvert, setJobAdvert] = useState({})
    
    useEffect(()=>{

        let jobAdvertService = new JobAdvertService();
        jobAdvertService.getJobAdvertById(id).then(result=>setJobAdvert(result.data.data))

    },[])



    return (
        
        <div>
                
                Details will be here {id}

        </div>
    )
}
