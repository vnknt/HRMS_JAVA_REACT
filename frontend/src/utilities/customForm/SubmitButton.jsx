import React, { useEffect } from 'react'

export default function SubmitButton(props) {

    let {text,...fields} = props;

    return (
        <button type="submit" {...fields}>{text}</button>
    )
}
