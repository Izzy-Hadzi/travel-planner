const API_BASE_URL = 'http://localhost:8080/api';

// User API calls
export const userAPI = {
  createUser: async (userData) => {
    const response = await fetch(`${API_BASE_URL}/users`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(userData)
    });
    if (!response.ok) {
      throw new Error('Failed to create user');
    }
    return response.json();
  },

  getUserById: async (userId) => {
    const response = await fetch(`${API_BASE_URL}/users/${userId}`);
    if (!response.ok) {
      throw new Error('Failed to get user');
    }
    return response.json();
  },

  getUserTrips: async (userId) => {
    const response = await fetch(`${API_BASE_URL}/users/${userId}/trips`);
    if (!response.ok) {
      throw new Error('Failed to get user trips');
    }
    return response.json();
  }
};