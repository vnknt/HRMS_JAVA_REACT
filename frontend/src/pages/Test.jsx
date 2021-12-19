import React from 'react';
import { Formik,Form } from 'formik';
import * as Yup from "yup"
import FormTextInput from '../components/customForm/FormTextInput';
import { Button } from 'semantic-ui-react';
export default function Test() {
    const initialValues = { productName: "", unitPrice: 10 }

    const scheme = Yup.object({
        productName: Yup.string().required("Ürün Adı Zorunlu"),
        unitPrice: Yup.number().required("Ürün Fiyatı Zorunlu")

    })

    return (
        
        <div>
        <Formik
            initialValues={initialValues}

            validationSchema={scheme}
            onSubmit={(values) => {
                console.log(values)
            }}


        >
            <Form>
                <FormTextInput name="productName"></FormTextInput>
                <FormTextInput name="unitPrice"></FormTextInput>
                <Button type="submit">Ekle</Button>        
            </Form>
           

        </Formik>
    </div>
    )
}
