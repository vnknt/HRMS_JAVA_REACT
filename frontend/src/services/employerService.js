import axios from 'axios'
import Constants from '../utilities/Constants'


export default class EmployerService{

    getEmployers(){
        let url= Constants.getApiUrl()
        return(axios.get(url+"employers/getall"))

    }

}