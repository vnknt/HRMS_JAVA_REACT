import './App.css';
import Navbar from './layouts/Navbar';
import 'semantic-ui-css/semantic.min.css';
import Dashboard from './layouts/Dashboard';
import { Container } from 'semantic-ui-react';
import HorizontalCard from './components/horizontalCard/HorizontalCard';

function App() {
  return (
    <div className="App">

      <Navbar/>
      <Container>
        <Dashboard></Dashboard>  
      
      </Container> 
      








    </div>
  );
}

export default App;
