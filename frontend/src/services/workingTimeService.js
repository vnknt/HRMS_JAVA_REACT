import Constants from "../utilities/Constants";
import axios from "axios";
export default class WorkingTypeService{

    getWorkingTimes(){
        let url = Constants.getApiUrl();
        return axios.get(url+"workingTimes/getAll")
    }


}