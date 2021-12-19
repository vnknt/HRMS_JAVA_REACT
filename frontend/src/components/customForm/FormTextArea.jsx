import { useField } from 'formik'
import React from 'react'
import FormInvalidFeedback from './FormInvalidFeedback'

export default function FormTextArea({...props}) {
    const [field,meta] = useField(props)

    return (
        <div>
            <textarea {...field} {...props} row={props.row} className={`form-control ${(meta.touched && !!meta.error)?"is-invalid":null}`}>
            </textarea>
            <FormInvalidFeedback meta={meta}></FormInvalidFeedback>
        </div>
    )
}
