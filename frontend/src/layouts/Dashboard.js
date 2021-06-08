import React from "react";
import { Grid } from "semantic-ui-react";
import JobAdverts from "../pages/JobAdverts";
import Sidebar from "./Sidebar/Sidebar";
import 'bootstrap/dist/css/bootstrap.min.css'
import { Col, Row } from "react-bootstrap";
export default function Dashboard() {
  return (
    <div>
      <>
        <Row>
            <Col sm={3} className="d-none d-sm-block  ">
                 <Sidebar></Sidebar>
            </Col>
            <Col xs={12} sm={9} className=""  >
              <JobAdverts></JobAdverts>
            </Col>
        </Row>
      </>
    </div>
  );
}
