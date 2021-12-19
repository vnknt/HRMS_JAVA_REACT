import UrlService from './urlService'
import axios from 'axios'
export default class CvService {

    CvService(){
        const url = UrlService.getApiUrl()
    }
    

    getAllCvs(){

        return axios.get(this.url+'cvs/getAll')
        
    }

    addCv(cv){
        return axios.post(this.url+"cvs/add",cv);
    }



    updateCv(cv){

        return axios.post(this.url+'cvs/update',cv)

    }



}