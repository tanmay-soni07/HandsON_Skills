import React, { Component } from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
      message: ''
    };
    // Binding this keyword for methods
    this.handleDecrement = this.handleDecrement.bind(this);
  }

  // 1a & 1b. Increment and Say Hello
  handleIncrementMultiple = () => {
    this.setState(prevState => ({ counter: prevState.counter + 1 }));
    this.sayHello();
  };

  sayHello = () => {
    this.setState({ message: 'Hello! Have a great day.' });
  };

  handleDecrement() {
    this.setState(prevState => ({ counter: prevState.counter - 1 }));
  }

  // 2. Function taking "welcome" as argument
  sayWelcome = (greeting) => {
    alert(greeting);
  };

  // 3. Synthetic event "OnPress"
  handleOnPress = (event) => {
    alert("I was clicked! Event type: " + event.type);
  };

  render() {
    return (
      <div className="App" style={{ padding: '20px' }}>
        <h1>Event Examples App</h1>
        
        {/* 1. Increment & Decrement */}
        <div>
          <h2>Counter: {this.state.counter}</h2>
          <button onClick={this.handleIncrementMultiple}>Increment</button>
          <button onClick={this.handleDecrement} style={{ marginLeft: '10px' }}>Decrement</button>
          {this.state.message && <p>{this.state.message}</p>}
        </div>

        <hr />

        {/* 2. Say Welcome */}
        <div>
          <button onClick={() => this.sayWelcome('Welcome!')}>Say Welcome</button>
        </div>

        <hr />

        {/* 3. Synthetic Event */}
        <div>
          <button onClick={this.handleOnPress}>OnPress</button>
        </div>

        <hr />

        {/* 4. Currency Convertor Component */}
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
