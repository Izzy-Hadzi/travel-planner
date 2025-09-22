import { useState, Router, Routes, Route, Page} from 'react'
import './App.css'
import Navbar from './components/NavBar.jsx'
import CreationForm from './components/creationForm.jsx'
import Dashboard from './components/Dashboard.jsx'


function App() {
  //const [count, setCount] = useState(0);
  const [currentUser, setCurrentUser] = useState(null)
  const [userTrips, setUserTrips] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)


  return (
    <div className="App">
      {error && (
        <div className="error">
          {error}
          <button onClick={() => setError(null)}>Dismiss</button>
        </div>
      )}
      
      {currentUser ? <Dashboard currentUser={currentUser} setCurrentUser={setCurrentUser} userTrips={userTrips} setUserTrips={setUserTrips} setLoading={setLoading} loading={loading} setError={setError}/> : <CreationForm setCurrentUser={setCurrentUser} setUserTrips={setUserTrips} setError={setError} setLoading={setLoading} loading={loading}/>}
    </div>
    );
}

export default App;
