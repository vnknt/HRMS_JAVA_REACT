import React from 'react'

export default function PositionSection(props) {
    return (
        <div className=" p-3 mt-3 border-top sidebar-section ">
            <div className="col text-center">
                <h5>İş Pozisyonları</h5>
            </div>
            <div className="divScrolled">
                {
                    props.jobs.map((job) => (
                        <div  className="p-1" key={job.jobId} >
                            <input id={`job-${job.jobId}`} className="form-check-input me-2" type="checkbox" value="" />
                            <label className="form-check-label w-75" htmlFor={`job-${job.jobId}`}> {job.jobName}</label>
                        </div>
                    ))
                }
            </div>
        </div >
    )
}
