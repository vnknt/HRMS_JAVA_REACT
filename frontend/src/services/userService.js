import { login } from "../store/actions/userAction"
import { url } from "./constants";
import axios from "axios";
export default class UserService{

    login(username,password){
        console.log(username,password)
        return axios.post(`${url}/auth`,{email:username,password:password})
        
    }

}


