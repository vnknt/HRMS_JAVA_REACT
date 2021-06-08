import UrlService from './urlService'
import axios from 'axios'
export default class CvService {

    CvService(){
        let url = UrlService.getApiUrl()
    }
    

    getAllCvs(){

        return axios.get(this.url+'/cvs/getAll')
        
    }





}