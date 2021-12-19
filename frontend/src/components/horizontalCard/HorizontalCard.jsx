import React from 'react'
import './horizontalCard.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import { Button } from 'semantic-ui-react'
import Moment from 'moment'
import { Link, NavLink } from 'react-router-dom'
import DateHelper from '../../utilities/DateHelper'


export default function horizontalCard(props) {
  

    return (
        <div className="horizontalCard">

       
        <div className="card mb-3" >
        <div className="row no-gutters">
          <div className="col-md-2 d-flex justify-content-center">
            <img className="horizontalCardImage align-center d-md-block" src={props.img} />
          </div>
          <div className="col-md-10">
            <div className="card-body">
              
              <Link to={props.link} className="advert-job"> <h5>{props.job} </h5></Link>
              <p className="card-text">
                 {props.company}
              </p>

              <div className="card-text row">
                  <div className="col-9 ">
                    <div className="col-12 d-block " >
                      <p>{props.description}&nbsp;</p>
                    </div>
                    <div className="col-12 text-right">
                    <small className="text-muted  advert-date">Son Başvuru  : {Moment(props.deadline).format('DD/MM/YYYY')}</small>
                    </div>
                     
                  </div>
                  <div className="col-md-3 col-sm-12 d-flex justify-content-end">
                    <div>
                        <Button as={NavLink} to={props.link} content='Git' icon='right arrow' labelPosition='right' />
                    </div>
               
                  </div>
                
              </div>
            
            

            </div>
          </div>
        </div>
      </div>

      </div>
    )
}
