import axios from 'axios';
import Constants from '../utilities/Constants';

export default class JobAdvertService {
     
   getJobAdverts(){
     let url= Constants.getApiUrl()
       return axios.get(url+"jobAdverts/getAllConfirmed")
       
   }
    
   getUnconfirmedJobAdverts(){
     let url= Constants.getApiUrl()
       return axios.get(url+"jobAdverts/getAllUnconfirmed")
     
 }
  


   getJobAdvertById(id){
     let url= Constants.getApiUrl()
       return axios.get(url+"jobAdverts/getById?id="+id)
   }



   addJobAdvert(jobAdvert){
     let url= Constants.getApiUrl()
       return axios.post(url+"jobAdverts/add",jobAdvert)

   }


   confirmJobAdvert(jobAdvertId){
     let url= Constants.getApiUrl()
       return axios.get(url+"jobAdverts/confirmJobAdvert?jobAdvertId="+jobAdvertId)

}





}
