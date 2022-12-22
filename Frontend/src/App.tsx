import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Dashboard from './Pages/Dashboard/Dashboard';
import University from './Pages/University/University';
import Login from './Pages/Login/Login';
import RestExample from './Services/RestExample';
import ReadUniversity from './Services/ReadUniversity';
import RestContextProvider from './Components/Helpers/RestContext';
import NavBar from './Services/NavBar';
import GetService from './Services/get/GetService';
import PostService from './Services/post/PostService';
import PutService from './Services/put/PutService';
import DeleteService from './Services/delete/DeleteService';
import DashboardTemplate from './Pages/DashboardTemplate';
import Home from './Services/Home';
import { Grid } from '@mui/material';

function App() {
    return(
        <>

<Switch>
    <Route exact path="/course">
        <Router>
          <DashboardTemplate>
            <Grid container spacing={3}>
              <Grid item xs={12}>
                <GetService />
              </Grid>
              <Grid item xs={6}>
                <PostService/>
              </Grid>
              <Grid item xs={6}>
                <PutService/>
              </Grid>
              <Grid item xs={12}>
                <DeleteService/>
              </Grid>
            </Grid>
          </DashboardTemplate>
        </Router>
    </Route>
    <Route exact path="/GetCourse">
        <div className="App-body">
          <NavBar/>
            <GetService/> 
        </div>
    </Route>
    <Route path="/dashboard">
        <RestContextProvider>
            <Dashboard/>
        </RestContextProvider>
    </Route>
    <Route path="/university">
        <RestContextProvider>
            <University/>
        </RestContextProvider>
    </Route>
    <Route path="/login">
        <Login/>
    </Route>
    <Route path="/testing">
        <RestExample/>
    </Route>
</Switch>

        </>
        
    );
}

export default App;

