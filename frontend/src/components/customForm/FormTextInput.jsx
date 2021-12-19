import { useField } from 'formik'
import React from 'react'
import { FormControl, Form } from 'react-bootstrap'
import FormInvalidFeedback from '../customForm/FormInvalidFeedback'
export default function FormTextInput({ ...props }) {
    const [field, meta] = useField(props)


    return (
        <div >
            <input {...field}  {...props} className={`form-control ${(meta.touched && meta.error) ? "is-invalid" : ""}`} placeholder={props.placeholder} autoComplete={props.autoComplete} />
           <FormInvalidFeedback meta={meta}/>
         
        </div >
    )
}
