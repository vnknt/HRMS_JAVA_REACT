
import moment from "moment";


export default class DateHelper{

    static getCurrentDate(){

        return moment().format("DD-MM-YYYY")

    }


    static getDateDifference(date){
        return moment.duration(moment(this.getCurrentDate(),"DD/MM/YYYY").diff(date,"DD/MM/YYYY")).humanize()
    }






}