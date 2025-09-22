import React, { useState} from 'react';
import { userAPI } from './../userApi.js';



function CreationForm({ setError, setLoading, setUserTrips, setCurrentUser, loading }) {
      const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        travellerType: 'COMFORT'
      })
  
      const handleSubmit = async (e) => {
        e.preventDefault()
        setLoading(true)
        setError(null)
        
        try {
          const user = await userAPI.createUser(formData)
          setCurrentUser(user)
          // Load user's trips (will be empty initially)
          const trips = await userAPI.getUserTrips(user.id)
          setUserTrips(trips)
        } catch (err) {
          setError('Failed to create user: ' + err.message)
        } finally {
          setLoading(false)
        }
      }
  
      return (
        <div className="user-form">
          <h1>Create Your Travel Account</h1>
          <form onSubmit={handleSubmit}>
            <div>
              <label>First Name:</label>
              <input
                type="text"
                value={formData.firstName}
                onChange={(e) => setFormData({...formData, firstName: e.target.value})}
                required
              />
            </div>
            
            <div>
              <label>Last Name:</label>
              <input
                type="text"
                value={formData.lastName}
                onChange={(e) => setFormData({...formData, lastName: e.target.value})}
                required
              />
            </div>
            
            <div>
              <label>Email:</label>
              <input
                type="email"
                value={formData.email}
                onChange={(e) => setFormData({...formData, email: e.target.value})}
                required
              />
            </div>
            
            <div>
              <label>Password:</label>
              <input
                type="password"
                value={formData.password}
                onChange={(e) => setFormData({...formData, password: e.target.value})}
                required
              />
            </div>
            
            <div>
              <label>Travel Style:</label>
              <select
                value={formData.travellerType}
                onChange={(e) => setFormData({...formData, travellerType: e.target.value})}
              >
                <option value="LUXURY">Luxury</option>
                <option value="COMFORT">Comfort</option>
                <option value="BASIC">Basic</option>
                <option value="BACKPACKER">Backpacker</option>
              </select>
            </div>
            
            <button type="submit" disabled={loading}>
              {loading ? 'Creating Account...' : 'Create Account'}
            </button>
          </form>
        </div>
      )
};
export default CreationForm;