import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import PostService from "./services/post/PostService";
import GetService from "./services/get/GetService";
import PutService from "./services/put/PutService";
import DeleteService from "./services/delete/DeleteService"
import Home from "./services/Home"
import NavBar from './services/NavBar';

/*
Note Before Testing
Make sure to run an instance of Chrome with disabled Security
and load the web app there
Run: "chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security"
*/

function App() {
  return (
    <Router>
      <div className="App-header">
        <NavBar/>
      </div>
      <div className="App-body">
        <Switch>
          <Route exact path="/">
            <Home/>
          </Route>
          <Route exact path="/GetCourse">
            <GetService/>
          </Route>
          <Route exact path="/PostCourse">
            <PostService/>
          </Route>
          <Route exact path="/PutCourse">
            <PutService/>
          </Route>
          <Route exact path="/DeleteCourse">
            <DeleteService/>
          </Route>
        </Switch>
      </div>
      <div className="App-footer">
        Internet Love Group 2022
      </div>
    </Router>
  );
}

export default App;