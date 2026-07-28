import React, { useState } from 'react';
import './App.css';

// Guest Component
const GuestPage = () => (
  <div style={{ marginTop: '20px' }}>
    <h2>Guest View</h2>
    <p>Welcome! Browse the latest flight details here.</p>
    <ul>
      <li>Flight 101 to New York - $250</li>
      <li>Flight 205 to London - $400</li>
      <li>Flight 302 to Tokyo - $650</li>
    </ul>
    <p>Please log in to book a ticket.</p>
  </div>
);

// User Component
const UserPage = () => {
  const [bookingStatus, setBookingStatus] = useState('');

  const handleBookTicket = (flight) => {
    setBookingStatus(`Successfully booked ${flight}! Have a safe trip.`);
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2>User View</h2>
      <p>Welcome back! You can now book your tickets.</p>
      <ul>
        <li>
          Flight 101 to New York - $250 
          <button onClick={() => handleBookTicket('Flight 101')} style={{ marginLeft: '10px' }}>Book Ticket</button>
        </li>
        <li>
          Flight 205 to London - $400 
          <button onClick={() => handleBookTicket('Flight 205')} style={{ marginLeft: '10px' }}>Book Ticket</button>
        </li>
        <li>
          Flight 302 to Tokyo - $650 
          <button onClick={() => handleBookTicket('Flight 302')} style={{ marginLeft: '10px' }}>Book Ticket</button>
        </li>
      </ul>
      {bookingStatus && <h3 style={{ color: 'green' }}>{bookingStatus}</h3>}
    </div>
  );
};

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Ticket Booking App</h1>
      
      <div>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        )}
      </div>

      <hr />

      {/* Conditional Rendering based on login state */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}

    </div>
  );
}

export default App;
