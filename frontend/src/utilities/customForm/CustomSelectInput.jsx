import { useField } from 'formik'
import {React,useEffect} from 'react'
import { FormField, Label } from 'semantic-ui-react'
import * as Yup from 'yup'

export default function CustomSelectInput(props) {
 
    const [field,meta] = useField(props)
    useEffect(() => {


    }, [props])



    return (
        <div>
            <FormField style={{position:"relative"}} error={ meta.touched && !!meta.error} >
                <select {...field} {...props} >
                    <option value={"default"}>{props.default}</option>
                    
                    {props.options &&

                       Object.entries(props.options).map((key)=>{
                           
                        
                            return <option value={key[0]}>{key[1]}</option>

                       })


                    }                    


                </select>
                {meta.touched && !!meta.error ? (
                    <Label pointing style={{position:"absolute",bottom:"-35px",zIndex:"999"}}  content={meta.error}></Label>
                ) :null 

                }

            </FormField>
        </div>
    )


}
