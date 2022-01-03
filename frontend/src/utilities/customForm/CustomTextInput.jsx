import { useField } from 'formik'
import React from 'react'
import { FormField, Label } from 'semantic-ui-react'

export default function CustomTextInput(props) {
    
    const [field,meta] = useField(props)
    
    
    return (
        <div>



            <FormField style={{position:"relative"}}  error={ meta.touched && !!meta.error} >
            <input {...field} {...props} ></input>
                    

              
                {meta.touched && !!meta.error ? (
                    <Label pointing  content={meta.error} style={{position:"absolute",bottom:"4px",left:0,zIndex:"999"}}></Label>
                ) :null 

                }

            </FormField>
            {/* <FormField style={{position:"relative"}}
                
            
            error={ meta.touched && !!meta.error} >
                <input {...field} {...props} />
                {meta.touched && !!meta.error ? (
                    <Label pointing  content={meta.error} style={{position:"absolute",bottom:"-35px",zIndex:"999"}}></Label>
                ) :null 

                }

            </FormField> */}
        </div>
    )

}
