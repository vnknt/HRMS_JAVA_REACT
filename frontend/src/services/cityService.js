import React from 'react';
import axios from 'axios';
import Constants from '../utilities/Constants'




export default class CityService  {
   


      
        
    
   
    getCities(){
        let url = Constants.getApiUrl()
        
        return axios.get(url+"cities/getAll")

    }





}
