import React from 'react'
import FormTitle from '../../utilities/customForm/FormTitle'

export default function FormWrapper(props) {
    let {title , ...fields} = props
    return (
        <div class="row d-flex justify-content-center">
            <FormTitle title={title}/>
            <div class="col-12 col-md-8 col-lg-6">
                {fields.children}
            </div>
            
        </div>
    )
}
