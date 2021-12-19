import React from 'react'

export default function FormInvalidFeedback(props) {
    return (
        <>
             {(props.meta.touched && props.meta.error) ? (
                <div className="invalid-feedback mb-1">
                    {props.meta.error}
                </div>
            ) : <div className="mb-1">&nbsp;</div>}
        </>
    )
}
