import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './App.css';
import axios from 'axios';

import { BACKEND_URL } from './constants';


class App extends Component {
    
      constructor(props){
        super(props);
      this.state={
          accountNumber:""      
      }   
     }
    
        handleClick = () => {  
            
          axios.get(`${BACKEND_URL}addAccountGen`).then(response => {
          
          this.setState({accountNumber: response.data.accountNumber});

          document.getElementById("second").click();
          
            }); 
    }
        
  render() {
      
  return (
                                              
    <Router>
      
      <div>
      
      <Link to="/second" id = "second"></Link>
      <Link to="/thirda" id = "thirda"></Link>
      <Link to="/thirdb" id = "thirdb"></Link>
       
      <Route exact path="/" render={(props) => <Home clickFunction={this.handleClick}  />} />
      <Route path="/second" render={(props) => <Second store={this.state.accountNumber}  />} /> 
      <Route path="/thirda" render={(props) => <ThirdA globalStore={this.state.accountNumber}  />} /> 
      <Route path="/thirdb"  component={ThirdB} /> 
      
      </div>
      
    </Router>
                                                   
    );
  }
}

 class Home extends Component {
     
      constructor(props){
        super(props);
        
     }
     
     render(){
  return (
    <div>
          <div className="App">
                                    
        <p>Create Account</p>
        <p>First Name</p>
        <input></input>
        <p>Last Name</p>
        <input></input>
        <br/>
        <button onClick={this.props.clickFunction}>Submit</button>
      </div>
  
    </div>
  );
}}

  class Second extends Component {
      
      constructor(props){  
          
        super(props);
      this.state={
                message:""
      }   
     }
     
     handleClick = () => {
            
         axios.get(`${BACKEND_URL}getPrize/`+this.props.store).then(response => {
                       
         if (!(response.data == "lose")){
            document.getElementById("thirda").click();  
         }else{
            document.getElementById("thirdb").click(); 
         }
     }
)}
             
  render() {
    return (
      <div className="App">
        
        <p>Account Successfully Created</p>
        <p>Account Number is:</p>
        <p>{this.props.store}</p>
        <p>Please click the button below button if you would like to enter our free prize draw</p>
     
        <button onClick={this.handleClick}>Redeem</button>
        
      </div>
      );
  }
}

 class ThirdA extends Component {
     
       constructor(props){
        
        super(props);
      this.state={
          message:""
                
      }   
     }
     
       handleClick = () => {
           console.log(this.props);     
           
        axios.get(`${BACKEND_URL}getPrize/`+ this.props.globalStore).then(response => {
      
                this.setState({message: response.data})
      
  });
                
            }
     
  render() {
    return (
      <div className="App">
        <p>Congratulations, you have won!</p>
        <p>Click the button below to reveal your prize</p>
        <button onClick = {this.handleClick}>Show Prize!</button>    
        <p>{this.state.message}</p>
      </div>
      );
  }
}

 class ThirdB extends Component {
  render() {
    return (
      <div className="App">
        <p>Unfortunately, you have not won on this occassion.</p>
      </div>
      );
  }
}


export default App;
