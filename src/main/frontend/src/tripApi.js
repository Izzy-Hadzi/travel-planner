const API_BASE_URL = 'http://localhost:8080/api';

// Trip API calls
export const tripAPI = {
  createTrip: async (userId, tripData) => {
    const response = await fetch(`${API_BASE_URL}/users/${userId}/trips`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(tripData)
    });
    if (!response.ok) {
      throw new Error('Failed to create trip');
    }
    return response.json();
  },

  getTripById: async (tripId) => {
    const response = await fetch(`${API_BASE_URL}/trips/${tripId}`);
    if (!response.ok) {
      throw new Error('Failed to get trip');
    }
    return response.json();
  }
};