import React, { Component } from 'react'
import Constants from '../utilities/Constants'
import axios from 'axios'
export default class JobService  {
  
    constructor(){
       
    }


    getJobs(){
      let url= Constants.getApiUrl()
       return axios.get(url+"jobs/getAll")

    }









}
