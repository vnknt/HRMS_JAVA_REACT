import './App.css';
import Nav from './layouts/Nav';
import 'semantic-ui-css/semantic.min.css';
import Dashboard from './layouts/Dashboard';
import { Container } from 'semantic-ui-react';
import HorizontalCard from './components/horizontalCard/HorizontalCard';
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Route } from 'react-router';
import Home from './pages/Home';
function App() {
  return (
    <div className="App">
      
      
      <Nav/>
      <Container className="mt-5">
        
        <Route exact path="/" component={Home}/>

        <Dashboard></Dashboard>  
      
      </Container> 
      
      <ToastContainer position="bottom-right"></ToastContainer>

    </div>
  );
}

export default App;
