import axios from 'axios';

export default class JobAdvertService {
     
   getJobAdverts(){

       return axios.get("http://localhost:8080/api/jobAdverts/getAllConfirmed")
       
   }
    
   getUnconfirmedJobAdverts(){

     return axios.get("http://localhost:8080/api/jobAdverts/getAllUnconfirmed")
     
 }
  


   getJobAdvertById(id){

        return axios.get("http://localhost:8080/api/jobAdverts/getById?id="+id)
   }



   addJobAdvert(jobAdvert){

        return axios.post("http://localhost:8080/api/jobAdverts/add",jobAdvert)

   }


   confirmJobAdvert(jobAdvertId){
     
     return axios.get("http://localhost:8080/api/jobAdverts/confirmJobAdvert?jobAdvertId="+jobAdvertId)

}





}
