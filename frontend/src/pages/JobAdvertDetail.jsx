import React, { useState } from 'react'
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import JobAdvertService from '../services/jobAdvertService'
import FormTextInput from '../components/customForm/FormTextInput'
export default function JobAdvertDetail() {

    let { id } = useParams()


    const [jobAdvert, setJobAdvert] = useState(null)

    useEffect(() => {

        let jobAdvertService = new JobAdvertService();
        jobAdvertService.getJobAdvertById(id).then(result => {
            console.log(result.data.data)
            setJobAdvert(result.data.data)

        })


    }, [])


    useEffect(() => {




    }, [jobAdvert])


    return (
        <>
            {jobAdvert != null ?

                <div className='mt-5 pt-5 col-12 row' >
                    <div className='col-3'>
                        <img width="100" src="https://cdn.dsmcdn.com/mnresize/415/622/ty1/product/media/images/20200403/12/1079057/67600378/1/1_org_zoom.jpg"/>
                    
                    </div>
                    <div className='col-9'>
                    
                        <h2>{jobAdvert.job.jobName}</h2>
                        <h5>{jobAdvert.employer.companyName}</h5>
                        <p>{jobAdvert.description}</p>

                    </div>
                </div>
                :
                ""
            }
        </>

    )
}
