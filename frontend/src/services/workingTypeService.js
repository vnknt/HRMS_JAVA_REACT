import React, { Component } from 'react'
import Constants from '../utilities/Constants'
import axios from 'axios'


export default class WorkingTypeService  {
   
  


    getWorkingTypes(){
        let url = Constants.getApiUrl()
        return axios.get(url+"workingTypes/getAll")

    }



}



