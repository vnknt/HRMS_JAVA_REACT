import { createStore } from "redux";
import rootReducer from "./rootReducer"
import { devToolsEnhancer } from "redux-devtools-extension";

export default function configureStore(params){

    return createStore(rootReducer,devToolsEnhancer())

    
}