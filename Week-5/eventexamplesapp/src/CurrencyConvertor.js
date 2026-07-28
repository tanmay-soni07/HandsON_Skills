import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState('');
  const [convertedAmount, setConvertedAmount] = useState(null);
  const [conversionType, setConversionType] = useState('inrToEuro');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!amount) return;

    // Assuming 1 Euro = 90 INR for this example
    const rate = 90;
    
    if (conversionType === 'inrToEuro') {
      const euro = parseFloat(amount) / rate;
      setConvertedAmount(`€${euro.toFixed(2)}`);
    } else {
      const inr = parseFloat(amount) * rate;
      setConvertedAmount(`₹${inr.toFixed(2)}`);
    }
  };

  return (
    <div style={{ marginTop: '20px', padding: '10px', border: '1px solid #ccc' }}>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            <input 
              type="radio" 
              value="inrToEuro" 
              checked={conversionType === 'inrToEuro'} 
              onChange={(e) => setConversionType(e.target.value)} 
            /> 
            INR to Euro
          </label>
          <label style={{ marginLeft: '10px' }}>
            <input 
              type="radio" 
              value="euroToInr" 
              checked={conversionType === 'euroToInr'} 
              onChange={(e) => setConversionType(e.target.value)} 
            /> 
            Euro to INR
          </label>
        </div>
        <div style={{ marginTop: '10px' }}>
          <input 
            type="number" 
            value={amount} 
            onChange={(e) => setAmount(e.target.value)} 
            placeholder="Enter amount" 
          />
          <button type="submit" style={{ marginLeft: '10px' }}>Convert</button>
        </div>
      </form>
      {convertedAmount && <h3 style={{ marginTop: '10px' }}>Result: {convertedAmount}</h3>}
    </div>
  );
};

export default CurrencyConvertor;
