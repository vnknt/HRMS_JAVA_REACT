import React, { useEffect, useState } from "react";
import * as Yup from "yup";
import JobAdvertService from "../services/jobAdvertService";
import CityService from "../services/cityService";
import JobService from "../services/jobService";
import WorkingTypeService from "../services/workingTypeService";
import WorkingTimeService from "../services/workingTimeService";
import { toast } from "react-toastify";
import FormTextInput from "../components/customForm/FormTextInput";
import FormSelect from "../components/customForm/FormSelect";
import FormTextArea from "../components/customForm/FormTextArea";
import { Formik, Form } from "formik";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";


export default function JobAdvertAdd() {
  let [cities, setCities] = useState([]);
  let [jobs, setJobs] = useState([]);
  let [workingTypes, setWorkingTypes] = useState([]);
  let [workingTimes, setWorkingTimes] = useState([])
  let [showModal, setShowModal] = useState(true);
  let jobAdvertService = new JobAdvertService();
  let history = useHistory()
  useEffect(() => {
    let cityService = new CityService();
    let jobService = new JobService();
    let workingTypeService = new WorkingTypeService();
    let workingTimeService = new WorkingTimeService();


    let role = localStorage.getItem("role")
    if(role!=="EMPLOYER"){
        history.push("/forbidden")
    }

    cityService.getCities().then((result) => {
      setCities(result.data.data);
    });

    jobService.getJobs().then((result) => {
      setJobs(result.data.data);
    });


    workingTypeService.getWorkingTypes().then(result => {
      setWorkingTypes(result.data.data)

    })

    workingTimeService.getWorkingTimes().then(result => {
      setWorkingTimes(result.data.data)
    })



  }, []);

  const initialValues = {

    jobId: "",
    cityId: "",
    minSalary: "",
    maxSalary: "",
    workingTime: "",
    workingType: "",
    description: ""


  }

  const validationScheme = Yup.object({
    jobId: Yup.string().required("Lütfen bir şehir seçiniz"),
    cityId: Yup.number().required("Lütfen bir şehir seçin"),
    minSalary: Yup.number(),
    maxSalary: Yup.number(),
    workingTime: Yup.number().required("Bu alan zorunlu"),
    workingType: Yup.number().required("Bu alan zorunlu"),
    description: Yup.string().required("Açıklama zorunlu").min(3).max(100)
  })

  const sendForm = (values)=>{
    let user_id = localStorage.getItem("user_id")


    let jobAdvert = {
      job:{jobId:values.jobId},
      city:{cityId:values.cityId},
      minSalary:values.minSalary,
      maxSalary:values.maxSalary,
      description:values.description,
      workingType:{workingTypeId:values.workingType},
      workingTime:{workingTimeId:values.workingTime},
      employer:{userId:user_id}
    }

    jobAdvertService.addJobAdvert(jobAdvert).then(result=>{

      if(result.data.success){
        toast.success("İlan başarıyla eklendi")
      }else{
        toast.error("İlan eklenemedi, bir hata oluştu")
      }

    })

  }


  return (


    <>

      <Formik
        initialValues={initialValues}
        validationSchema={validationScheme}
        onSubmit={(values) => { sendForm(values)}}

      >
        <Form>

          <div className="row">
            <div className="col-12 text-center mb-4"><h2>İş İlanı Yayınla</h2></div>




            <div className="col-12 col-md-6">
              <FormSelect name="cityId">
                <option value="">Şehir seçiniz</option>
                {
                  cities.map(city => (
                    <option value={city.cityId}>{city.cityName}</option>
                  ))
                }
              </FormSelect>

            </div>



            <div className="col-12 col-md-6">
              <FormSelect name="jobId">
                <option value="">Meslek Seçiniz</option>
                {
                  jobs.map(job => (
                    <option value={job.jobId}>{job.jobName}</option>
                  ))
                }
              </FormSelect>
            </div>

          


          <div className="col-6">
            <FormSelect name="workingType">
              <option value="">Çalışma Şekli</option>
              {
                workingTypes.map(workingType => (
                  <option value={workingType.workingTypeId}>{workingType.workingType}</option>
                ))
              }
            </FormSelect>
          </div>


          <div className="col-6">
            <FormSelect name="workingTime">
              <option value="">Çalışma Zamanı</option>
              {
                workingTimes.map(workingTime => (
                  <option value={workingTime.workingTimeId}>{workingTime.workingTime}</option>
                ))
              }
            </FormSelect>
          </div>


          <div className="col-6 ">
            <FormTextInput name="minSalary" placeholder="Minimum Maaş"/>
          </div>


          <div className="col-6 ">
            <FormTextInput name="maxSalary" placeholder="Maximum Maaş"/>
          </div>



          <div className="col-12 ">
            <FormTextArea name="description"  style={{height:"100px"}} placeholder="Maximum Maaş"/>
          </div>









          <div className="col-12 d-flex justify-content-end px-5" >
            <button className="btn btn-danger me-3 col-4 col-md-1" type="reset">Sıfırla</button>
            <button className="btn btn-primary col-8 col-md-3" type="submit">Gönder</button>
          </div>
        </div>
        </Form>
      </Formik>
    </>
  );
}
