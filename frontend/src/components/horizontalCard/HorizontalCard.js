import React from 'react'
import './horizontalCard.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import { Button } from 'semantic-ui-react'
import Moment from 'moment'

export default function horizontalCard(props) {
  

    return (
        <div class="horizontalCard">

       
        <div class="card mb-3" >
        <div class="row no-gutters">
          <div class="col-md-2 d-flex justify-content-center">
            <img className="horizontalCardImage align-center d-md-block d-none" src={props.img} />
          </div>
          <div class="col-md-10">
            <div class="card-body">
              <a class="advert-job" href={props.titleUrl} >{props.job} </a>
              <p class="card-text">
                 {props.company}
              </p>

              <div class="card-text row">
                  <div class="col-9 ">
                    <div class="col-12" >
                    <small class="text-muted  advert-date">İlan Tarihi   : {Moment(props.creationDate).format('DD/MM/YYYY')}</small>
                    </div>
                    <div class="col-12 text-right">
                    <small class="text-muted  advert-date">Son Başvuru  : {Moment(props.deadline).format('DD/MM/YYYY')}</small>
                    </div>
                     
                  </div>
                  <div class="col-md-3 col-sm-12 d-flex justify-content-end">
                    <div>
                       
                        <Button content='Git' icon='right arrow' labelPosition='right' />

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
