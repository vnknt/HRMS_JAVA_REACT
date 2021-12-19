import { useField } from 'formik'
import React from 'react'
import FormInvalidFeedback from './FormInvalidFeedback'

export default function FormSelect({...props}) {
    const [field,meta] = useField(props)

    return (
        <div>
            <select {...props} {...field} className={`form-select ${(meta.touched && meta.error) ? "is-invalid" : ""}`}>
                
            </select>
            <FormInvalidFeedback meta={meta}></FormInvalidFeedback>
        </div>
    )
}
