import { React, useState, useEffect } from 'react'
import { Form, Formik } from 'formik'
import * as Yup from 'yup'
import CustomTextInput from '../../utilities/customForm/CustomTextInput'
import UserService from '../../services/userService'
import { Redirect, useHistory } from 'react-router'
import { useSelector, useDispatch } from 'react-redux'

import { login } from '../../store/actions/userAction'
import FormTitle from '../../utilities/customForm/FormTitle'
import SubmitButton from '../../utilities/customForm/SubmitButton'
import FormWrapper from '../../components/formWrapper/FormWrapper'
import { Link } from 'react-router-dom'
import styles from './Login.module.css'
import { toast } from 'react-toastify'

export default function Login() {
    const isUserLoggedIn = useSelector((state) => state.user)
    const dispatch = useDispatch()
    const history = useHistory()
    const initialValues = {
        username: "",
        password: ""
    }

    const schema = Yup.object({

        username: Yup.string().required().min(3).max(45),
        password: Yup.string().required()


    });

    useEffect(() => {


        if (false && isUserLoggedIn) {
            history.push("/")
        }

    }, [isUserLoggedIn])


    async function handleLogin(values) {

        let userService = new UserService()
        let loginResult = await userService.login(values.username, values.password)
        loginResult = loginResult.data

        if (loginResult.success) {
            
            let accessToken = loginResult.data.accessToken;
            
            dispatch(login({ accessToken:accessToken }))
            
        } else {

            toast.error("username or password is wrong",{autoClose:10000})

        }

    }




    return (
        <>


            {isUserLoggedIn ?


                <Redirect to="/"></Redirect> :
                <FormWrapper title="LOGIN">

                    <Formik
                        initialValues={initialValues}
                        validationSchema={schema}
                        onSubmit={(values) => handleLogin(values)}

                    >

                        <Form className="form-row ui form">
                            <CustomTextInput className="mb-5 " name="username" placeholder="E-mail or username"   ></CustomTextInput>
                            <CustomTextInput className="mb-5 " name="password" placeholder="Password" type="password"   ></CustomTextInput>
                            <div class="row justify-content-center">
                                <SubmitButton text="Login" className="col-12 col-md-8 col-lg-8 btn btn-primary" ></SubmitButton>
                                <div className="row justify-content-center">

                                    {/* <Link to="/register" className={`col-12 text-center mt-3 ${styles.link}`}>Create an account</Link> */}
                                </div>
                            </div>
                        </Form>

                    </Formik>


                </FormWrapper>




            }
        </>


    )
}
