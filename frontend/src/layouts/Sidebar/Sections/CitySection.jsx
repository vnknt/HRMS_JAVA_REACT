import React from 'react'

export default function CitySection(props) {
  return (
    <div className="overflow-auto p-3 border-top sidebar-section  ">
      <div className="col text-center">
        <h5>İller</h5>
      </div>
      <div className="divScrolled">

        {
          props.cities.map((city) => (

            <div  className="p-1  " key={city.cityId}>
              <input id={`city-${city.cityId}`} className="form-check-input me-2" type="checkbox" value="" />
              <label className="form-check-label w-75" htmlFor={`city-${city.cityId}`} > {city.cityName}</label>
            </div>

          ))
        }




      </div>

    </div >

  )
}
