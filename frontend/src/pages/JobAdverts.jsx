import { React, useState, useEffect } from "react";
import { Item, ItemContent } from "semantic-ui-react";
import HorizontalCard from "../components/horizontalCard/HorizontalCard";
import JobAdvertService from "../services/jobAdvertService";
import UrlService from "../services/urlService";
import { Col, Row } from "react-bootstrap";
export default function JobAdverts() {
  const [jobAdverts, setJobAdverts] = useState([]);

  useEffect(() => {
    let jobAdvertService = new JobAdvertService();

    jobAdvertService
      .getJobAdverts()
      .then((result) => setJobAdverts(result.data.data));
  }, []);


  let url = "localhost:3000/"
  return (
    <Col>



      <Row className="d-flex justify-content-end pb-3">
        <Col className="col-6 col-md-3 ">
          <select className="form-select">
            <option>En Yeni</option>
          </select>
        </Col>
      </Row>

      <Row>

        <Col>
          {

            jobAdverts.map((jobAdvert) => (
              <HorizontalCard key={jobAdvert.jobAdvertId} img={"https://cdn.dsmcdn.com/mnresize/415/622/ty1/product/media/images/20200403/12/1079057/67600378/1/1_org_zoom.jpg"}
                job={jobAdvert.job.jobName}
                link={"/job-advert/detail/" + jobAdvert.jobAdvertId}
                company={jobAdvert.employer.companyName}
                description={jobAdvert.description}
                deadline={jobAdvert.deadline} ></HorizontalCard>
            ))

          }
        </Col>


      </Row>

    </Col>

  );
}
