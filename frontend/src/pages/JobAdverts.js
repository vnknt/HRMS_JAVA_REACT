import { React, useState, useEffect } from "react";
import { Item, ItemContent } from "semantic-ui-react";
import HorizontalCard from "../components/horizontalCard/HorizontalCard";
import JobAdvertService from "../services/jobAdvertService";
import UrlService from "../services/urlService";

export default function JobAdverts() {
  const [jobAdverts, setJobAdverts] = useState([]);

  useEffect(() => {
    let jobAdvertService = new JobAdvertService();

    jobAdvertService
      .getJobAdverts()
      .then((result) => setJobAdverts(result.data.data));
  },[]);

  




  
  
  return (

    jobAdverts.map((jobAdvert)=>(

      <HorizontalCard img={"https://cdn.dsmcdn.com/mnresize/415/622/ty1/product/media/images/20200403/12/1079057/67600378/1/1_org_zoom.jpg"} 
      job={jobAdvert.job.jobName} 
      titleUrl = {jobAdvert.jobAdvertId}
      company={jobAdvert.employer.companyName} 
      description={jobAdvert.description}
      deadline={jobAdvert.deadline
      
      
      } ></HorizontalCard>
    
      ))  

    



  );
}
