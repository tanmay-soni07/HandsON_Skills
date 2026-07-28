import React from 'react';
import './App.css';

function App() {
  const officeSpaces = [
    {
      id: 1,
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: "https://images.unsplash.com/photo-1497366216548-37526070297c?ixlib=rb-4.0.3&auto=format&fit=crop&w=400&q=80"
    }
  ];

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Office Space , at Affordable Range</h1>
      {officeSpaces.map((office) => (
        <div key={office.id} style={{ marginBottom: '30px' }}>
          <img src={office.image} alt={office.name} style={{ width: '300px', height: '200px', objectFit: 'cover' }} />
          <h2>Name: {office.name}</h2>
          <h3 style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rent: Rs. {office.rent}
          </h3>
          <h4>Address: {office.address}</h4>
        </div>
      ))}
    </div>
  );
}

export default App;
