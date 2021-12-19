import React from "react";
import { Grid } from "semantic-ui-react";
import JobAdverts from "../pages/JobAdverts";
import JobAdvertDetail from "../pages/JobAdvertDetail";
import Sidebar from "./Sidebar/Sidebar.jsx";

import { Col, Row } from "react-bootstrap";
import { Route, Router } from "react-router-dom";
import JobAdvertAdd from "../pages/JobAdvertAdd";
import menuEmployer from "../components/menuEmployer/menuEmployer";
import Test from "../pages/Test";
import JobAdvertConfirm from "../pages/JobAdvertConfirm";

export default function Dashboard() {
  return (
    <div>
      
        <Row>
            <Col className="col-lg-3 d-none d-lg-block  mt-5  ">
            <Route exact path="/job-adverts" component={Sidebar}/>
            
            <Route exact path="/job-advert/add" component={menuEmployer}/>
                
            </Col>
            <Col  className="col-sm-12 col-lg-9 "  >
              
              <Col className="">
                
                <Route exact path="/job-adverts" component={JobAdverts}/>
                <Route exact path="/job-advert/detail/:id" component={JobAdvertDetail}/>
                <Route exact path="/job-advert/add" component={JobAdvertAdd}/>
                <Route exact path="/job-adverts/confirm" component={JobAdvertConfirm}/>
                
              </Col>

            </Col>
        </Row>
      
    </div>
  );
}
