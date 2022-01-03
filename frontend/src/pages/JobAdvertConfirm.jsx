import React,{useState,useEffect} from 'react'
import { useHistory } from 'react-router-dom';
import { toast } from 'react-toastify';
import JobAdvertService from '../services/jobAdvertService'

export default function JobAdvertConfirm() {

    const [jobAdverts,setJobAdverts] = useState([])

    let jobAdvertService = new JobAdvertService();
    let history = useHistory()

    useEffect(()=>{
        console.log(jobAdverts)
    let role = localStorage.getItem("role")
    if(role!=="SYSTEM_USER"){
        history.push("/forbidden")
    }
        jobAdvertService.getUnconfirmedJobAdverts().then(result=>{
            setJobAdverts(result.data.data)
        })


    },[])

    const confirmJobAdvert = (jobAdvertId)=>{
       jobAdvertService.confirmJobAdvert(jobAdvertId).then(result=>{
           if(result.data.success){
               toast.success("Onaylandı");
               setJobAdverts(jobAdverts.filter(jobAdvert=>jobAdvert.jobAdvertId!=jobAdvertId))
           }else{
               toast.error("Onay İşlemi Başarısız");
           }
       })
    }

    return (
        <>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th scope="">Id</th>
                        <th scope="">Yayınlayan</th>
                        <th scope="">İş Türü</th>
                        
                        <th scope="">Açıklama</th>
                        <th scope="">İşlem</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        jobAdverts.map(jobAdvert=>(

                            <tr>
                            <td>
                                {jobAdvert.jobAdvertId}
                            </td>
                            <td>
                                {jobAdvert.employer.companyName}
                            </td><td>
                                {jobAdvert.workingTime.workingTime}
                            </td>
                            <td>
                            {jobAdvert.description}
                            </td>
                            <td>
                            
                            <button className="btn btn-primary" onClick={(e)=>confirmJobAdvert(jobAdvert.jobAdvertId,e)}>Onayla</button>
                                
                            </td>
                            
                        </tr>


                        ))

                    }
                   
                </tbody>

            </table>
        </>
    )
}
