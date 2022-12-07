import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Dashboard from './Pages/Dashboard/Dashboard';
import University from './Pages/University/University';

function App() {
    return(
        <Router>
        <div className="App">
            <Switch>
                <Route path="/dashboard">
                    <Dashboard/>
                </Route>
                <Route path="/university">
                    <University/>
                </Route>
            </Switch>
        </div> 
        </Router>
    );
}

export default App;

