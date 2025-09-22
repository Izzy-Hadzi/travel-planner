import React, { useState} from 'react';
import { userAPI} from './../userApi.js'
import { tripAPI } from './../tripApi.js';
// Dashboard Component
const Dashboard = ({currentUser, setCurrentUser, userTrips, setUserTrips, setLoading, loading, setError}) => {
    const [showTripForm, setShowTripForm] = useState(false)
    const [tripFormData, setTripFormData] = useState({
      duration: 1
    })

    const handleCreateTrip = async (e) => {
      e.preventDefault()
      setLoading(true)
      setError(null)
      
      try {
        const trip = await tripAPI.createTrip(currentUser.id, tripFormData)
        // Refresh user's trips
        const trips = await userAPI.getUserTrips(currentUser.id)
        setUserTrips(trips)
        setShowTripForm(false)
        setTripFormData({ duration: 1 })
      } catch (err) {
        setError('Failed to create trip: ' + err.message)
      } finally {
        setLoading(false)
      }
    }

    return (
      <div className="dashboard">
        <h1>Welcome, {currentUser.firstName}!</h1>
        
        <div className="dashboard-actions">
          <button onClick={() => setShowTripForm(!showTripForm)}>
            {showTripForm ? 'Cancel' : 'Create New Trip'}
          </button>
          <button onClick={() => setCurrentUser(null)}>
            Switch User
          </button>
        </div>

        {showTripForm && (
          <div className="trip-form">
            <h3>Create New Trip</h3>
            <form onSubmit={handleCreateTrip}>
              <div>
                <label>Duration (days):</label>
                <input
                  type="number"
                  min="1"
                  value={tripFormData.duration}
                  onChange={(e) => setTripFormData({...tripFormData, duration: parseInt(e.target.value)})}
                  required
                />
              </div>
              <button type="submit" disabled={loading}>
                {loading ? 'Creating Trip...' : 'Create Trip'}
              </button>
            </form>
          </div>
        )}

        <div className="trips-section">
          <h2>Your Trips ({userTrips.length})</h2>
          {userTrips.length === 0 ? (
            <p>No trips yet. Create your first trip!</p>
          ) : (
            <div className="trips-list">
              {userTrips.map(trip => (
                <div key={trip.id} className="trip-card">
                  <h4>Trip #{trip.id}</h4>
                  <p>Duration: {trip.duration} days</p>
                  <p>Created: {new Date(trip.createdAt).toLocaleDateString()}</p>
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    )
  };
  export default Dashboard;